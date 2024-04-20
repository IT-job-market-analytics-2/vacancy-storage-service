package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.LogoUrls;
import com.dragunov.vacancystorageservice.model.LogoUrlsEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LogoUrlsEntityMapper {
    LogoUrlsEntity toEntity(LogoUrls logoUrlsDto);
}
