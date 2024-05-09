package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Salary;
import com.dragunov.vacancystorageservice.model.SalaryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T12:11:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class SalaryEntityMapperImpl implements SalaryEntityMapper {

    @Override
    public SalaryEntity toEntity(Salary salaryDto) {
        if ( salaryDto == null ) {
            return null;
        }

        SalaryEntity salaryEntity = new SalaryEntity();

        salaryEntity.setFrom( salaryDto.getFrom() );
        salaryEntity.setTo( salaryDto.getTo() );
        salaryEntity.setCurrency( salaryDto.getCurrency() );
        salaryEntity.setGross( salaryDto.getGross() );

        return salaryEntity;
    }
}
