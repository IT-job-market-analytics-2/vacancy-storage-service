package com.dragunov.vacancystorageservice.repository;

import com.dragunov.vacancystorageservice.model.VacanciesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacanciesRepository extends MongoRepository<VacanciesEntity, String> {
}
