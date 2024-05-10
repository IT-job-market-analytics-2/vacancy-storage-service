package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Snippet;
import com.dragunov.vacancystorageservice.model.SnippetEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-10T17:59:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class SnippetEntityMapperImpl implements SnippetEntityMapper {

    @Override
    public SnippetEntity toEntity(Snippet snippetDto) {
        if ( snippetDto == null ) {
            return null;
        }

        SnippetEntity snippetEntity = new SnippetEntity();

        snippetEntity.setRequirement( snippetDto.getRequirement() );
        snippetEntity.setResponsibility( snippetDto.getResponsibility() );

        return snippetEntity;
    }
}
