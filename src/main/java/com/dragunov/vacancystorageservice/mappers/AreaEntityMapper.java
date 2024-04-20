package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Area;
import com.dragunov.vacancystorageservice.model.AreaEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AreaEntityMapper {
    AreaEntity toEntity(Area areaDto);
}
