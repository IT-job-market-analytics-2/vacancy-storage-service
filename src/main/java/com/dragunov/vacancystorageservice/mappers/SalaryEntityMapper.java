package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Salary;
import com.dragunov.vacancystorageservice.model.SalaryEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SalaryEntityMapper {
    SalaryEntity toEntity(Salary salaryDto);
}
