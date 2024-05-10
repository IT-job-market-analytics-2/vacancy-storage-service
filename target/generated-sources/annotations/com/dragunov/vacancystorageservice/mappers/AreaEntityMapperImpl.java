package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Area;
import com.dragunov.vacancystorageservice.model.AreaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-10T17:59:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class AreaEntityMapperImpl implements AreaEntityMapper {

    @Override
    public AreaEntity toEntity(Area areaDto) {
        if ( areaDto == null ) {
            return null;
        }

        AreaEntity areaEntity = new AreaEntity();

        areaEntity.setId( areaDto.getId() );
        areaEntity.setName( areaDto.getName() );
        areaEntity.setUrl( areaDto.getUrl() );

        return areaEntity;
    }
}
