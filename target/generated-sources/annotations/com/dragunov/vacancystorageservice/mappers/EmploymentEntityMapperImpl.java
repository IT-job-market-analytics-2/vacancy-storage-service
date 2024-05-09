package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Employer;
import com.dragunov.vacancystorageservice.model.EmployerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T12:11:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class EmploymentEntityMapperImpl implements EmploymentEntityMapper {

    @Override
    public EmployerEntity toEntity(Employer employerDto) {
        if ( employerDto == null ) {
            return null;
        }

        EmployerEntity employerEntity = new EmployerEntity();

        employerEntity.setId( employerDto.getId() );
        employerEntity.setName( employerDto.getName() );
        employerEntity.setUrl( employerDto.getUrl() );
        employerEntity.setAlternateUrl( employerDto.getAlternateUrl() );
        employerEntity.setVacanciesUrl( employerDto.getVacanciesUrl() );
        employerEntity.setAccreditedItEmployer( employerDto.getAccreditedItEmployer() );
        employerEntity.setTrusted( employerDto.getTrusted() );

        return employerEntity;
    }
}
