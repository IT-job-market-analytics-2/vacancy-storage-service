package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.LogoUrls;
import com.dragunov.vacancystorageservice.model.LogoUrlsEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T12:11:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class LogoUrlsEntityMapperImpl implements LogoUrlsEntityMapper {

    @Override
    public LogoUrlsEntity toEntity(LogoUrls logoUrlsDto) {
        if ( logoUrlsDto == null ) {
            return null;
        }

        LogoUrlsEntity logoUrlsEntity = new LogoUrlsEntity();

        logoUrlsEntity.setOriginal( logoUrlsDto.getOriginal() );
        logoUrlsEntity.set_90( logoUrlsDto.get_90() );
        logoUrlsEntity.set_240( logoUrlsDto.get_240() );

        return logoUrlsEntity;
    }
}
