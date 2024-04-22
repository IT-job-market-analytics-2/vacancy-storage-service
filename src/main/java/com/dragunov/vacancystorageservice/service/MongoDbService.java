package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.model.VacanciesEntity;
import com.dragunov.vacancystorageservice.repository.VacanciesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MongoDbService {

    private final VacanciesRepository repository;
    private final MongoTemplate mongoTemplate;

    @Value("${spring.data.mongodb.ttl_index}")
    private int indexTtl;

    @Autowired
    public MongoDbService(VacanciesRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    public void addEntity(VacanciesEntity entity) {
        try {
            if (entity == null || entity.getVacancies() == null){
                throw new NullPointerException();
            }
            log.info("Set TTL index for VacanciesEntity - {} days", indexTtl);
            mongoTemplate.indexOps(VacanciesEntity.class).ensureIndex(new Index().expire(indexTtl, TimeUnit.DAYS)
                    .on("createdAt", Sort.Direction.ASC));
            log.info("Saving {}", entity);
            repository.save(entity);
        } catch (DuplicateKeyException e) {
            log.error("Saving fail duplicate key");
        } catch (NullPointerException b) {
            log.error("Save error because entity or vacancies is null");
        }
    }

    public List<VacanciesEntity> findAllEntity() {
        return repository.findAll();
    }

    public VacanciesEntity getEntityById(String id) {
        return repository.findById(id).get();
    }
}
