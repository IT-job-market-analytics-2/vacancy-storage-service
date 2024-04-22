package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Type;
import com.dragunov.vacancystorageservice.model.TypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeEntityMapper {
    TypeEntity toEntity(Type typeDto);
}
