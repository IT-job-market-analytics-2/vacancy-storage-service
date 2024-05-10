package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Type;
import com.dragunov.vacancystorageservice.model.TypeEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-10T17:59:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class TypeEntityMapperImpl implements TypeEntityMapper {

    @Override
    public TypeEntity toEntity(Type typeDto) {
        if ( typeDto == null ) {
            return null;
        }

        TypeEntity typeEntity = new TypeEntity();

        typeEntity.setId( typeDto.getId() );
        typeEntity.setName( typeDto.getName() );

        return typeEntity;
    }
}
