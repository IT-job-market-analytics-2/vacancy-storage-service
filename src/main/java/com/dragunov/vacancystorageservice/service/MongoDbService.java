package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.model.VacanciesEntity;
import com.dragunov.vacancystorageservice.repository.VacanciesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

@Service
@Slf4j
public class MongoDbService {

    private final VacanciesRepository repository;

    @Autowired
    public MongoDbService(VacanciesRepository repository) {
        this.repository = repository;
    }

    public VacanciesEntity addEntity(VacanciesEntity entity) {
        try {
            log.info("Saving {}", entity);
            return repository.save(entity);
        } catch (DuplicateKeyException e) {
            log.error("Saving fail duplicate key");
            return entity;
        }
    }

    public List<VacanciesEntity> findAllEntity() {
        return repository.findAll();
    }

    public VacanciesEntity getEntityById(String id) {
        return repository.findById(id).get();
    }
}
