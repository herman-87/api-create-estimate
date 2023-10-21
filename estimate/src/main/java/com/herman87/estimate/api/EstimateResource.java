package com.herman87.estimate.api;

import org.openapitools.api.EstimateApi;
import org.openapitools.model.EstimateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstimateResource implements EstimateApi {

    @Override
    public ResponseEntity<Void> createEstimate(EstimateDTO estimateDTO) {
        return null;
    }
}
