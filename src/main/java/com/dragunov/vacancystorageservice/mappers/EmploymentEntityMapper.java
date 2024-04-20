package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Employer;
import com.dragunov.vacancystorageservice.model.EmployerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmploymentEntityMapper {
    EmployerEntity toEntity(Employer employerDto);
}
