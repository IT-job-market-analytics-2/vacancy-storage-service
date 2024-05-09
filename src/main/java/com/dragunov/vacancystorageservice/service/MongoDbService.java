package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.model.VacancyEntity;
import com.dragunov.vacancystorageservice.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class MongoDbService {

    private final VacancyRepository repository;

    private final MongoTemplate mongoTemplate;

    @Value("${spring.data.mongodb.ttl_index}")
    private int indexTtl;

    private boolean isIndexExist(String collectionName, String indexName) {
        for (IndexInfo indexInfo : mongoTemplate.indexOps(collectionName).getIndexInfo()) {
            if (indexInfo.getName().equals(indexName)) {
                return true;
            }
        }
        return false;
    }

    private Date parseDataFromVacancy(VacancyEntity vacancy) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        log.info("published vacancy date {}", vacancy.getPublishedAt());
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.parse(vacancy.getPublishedAt());
    }

    public void addEntity(VacancyEntity entity) throws DuplicateKeyException, NullPointerException, ParseException {
        if (isIndexExist("vacancy", "deleteAt_1")) {
            mongoTemplate.indexOps(VacancyEntity.class).dropIndex("deleteAt_1");
            log.warn("Delete old ttl index");
        }
        entity.setDeleteAt(parseDataFromVacancy(entity));
        mongoTemplate.indexOps(VacancyEntity.class).ensureIndex(new Index().expire(indexTtl, TimeUnit.DAYS)
                .on("deleteAt", Sort.Direction.ASC));
        log.info("Set TTL index for VacanciesEntity - {} days", indexTtl);
        repository.save(entity);
        log.info("Save success {}", entity);
    }

    public List<VacancyEntity> findAllEntity() {
        return repository.findAll();
    }

    public VacancyEntity getEntityById(String uuid) {
        return repository.findById(uuid).get();
    }
}
