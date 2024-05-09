package com.dragunov.vacancystorageservice.repository;

import com.dragunov.vacancystorageservice.model.VacancyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends MongoRepository<VacancyEntity, String> {
}
