package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.model.VacancyEntity;
import com.dragunov.vacancystorageservice.repository.VacancyRepository;
import com.dragunov.vacancystorageservice.utils.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class MongoDbService {

    private final VacancyRepository repository;

    private final MongoTemplate mongoTemplate;

    @Value("${spring.data.mongodb.ttl_index}")
    private int indexTtl;

    private Date parseDataFromVacancy(VacancyEntity vacancy) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        log.info("published vacancy date {}", vacancy.getPublishedAt());
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.parse(vacancy.getPublishedAt());
    }

    private void setTtlIndex(VacancyEntity entity) throws ParseException {
        mongoTemplate.indexOps(VacancyEntity.class).ensureIndex(new Index().expire(indexTtl, TimeUnit.DAYS)
                .on("deleteAt", Sort.Direction.ASC));
        log.info("Set TTL index for VacanciesEntity - {} days", indexTtl);
    }

    private boolean isIndexExist(String collectionName, String indexName) {
        for (IndexInfo indexInfo : mongoTemplate.indexOps(collectionName).getIndexInfo()) {
            if (indexInfo.getName().equals(indexName)) {
                return true;
            }
        }
        return false;
    }

    private void deleteOldTtlIndex() {
        if (isIndexExist("vacancy", "deleteAt_1")) {
            mongoTemplate.indexOps(VacancyEntity.class).dropIndex("deleteAt_1");
            log.warn("Delete old TTL index");
        }
    }

    public void addEntity(VacancyEntity entity) throws DuplicateKeyException, NullPointerException, ParseException {
        entity.setDeleteAt(parseDataFromVacancy(entity));
        repository.save(entity);
        log.info("Save success {}", entity);
    }

    public void addQueryToVacancy(String query, VacancyEntity entity) {
        String validateQuery = Validator.validateQuery(query);
        if (entity.getQuery().contains(validateQuery)) {
            log.info("Set already contains {}", validateQuery);
        } else {
            entity.getQuery().add(validateQuery);
            log.info("Add {} to set", validateQuery);
            updateEntity(entity);
        }
    }

    public void updateEntity(VacancyEntity entity) {
        mongoTemplate.findAndReplace(
                new Query(Criteria.where("uuid").is(entity.getUuid())),
                entity, "vacancy");
    }

    public List<VacancyEntity> findAllEntity() {
        return repository.findAll();
    }

    public Optional<VacancyEntity> getEntityById(String uuid) {
        return repository.findByUuid(uuid);
    }
}
