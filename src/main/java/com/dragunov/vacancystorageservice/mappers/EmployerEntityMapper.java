package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Employer;
import com.dragunov.vacancystorageservice.model.EmployerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring", uses = {LogoUrlsEntityMapper.class})
public interface EmployerEntityMapper {

    @Mapping(target = "logoUrlsEntity", source = "employerDto.logoUrls")
    @Named("customMapping")
    EmployerEntity toEntity(Employer employerDto);
}
