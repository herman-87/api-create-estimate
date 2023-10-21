package com.herman87.estimate.service.mapper;

import com.herman87.estimate.domain.documents.Estimate;
import javax.annotation.processing.Generated;
import org.openapitools.model.EstimateDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-21T19:02:17+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
public class EstimateMapperImpl implements EstimateMapper {

    @Override
    public Estimate fromDTO(EstimateDTO value) {
        if ( value == null ) {
            return null;
        }

        Estimate.EstimateBuilder estimate = Estimate.builder();

        estimate.title( value.getTitle() );
        estimate.description( value.getDescription() );

        return estimate.build();
    }
}
