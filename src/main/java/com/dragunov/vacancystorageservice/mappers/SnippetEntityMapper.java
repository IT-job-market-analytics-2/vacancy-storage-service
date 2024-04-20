package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Snippet;
import com.dragunov.vacancystorageservice.model.SnippetEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SnippetEntityMapper {
    SnippetEntity toEntity(Snippet snippetDto);
}
