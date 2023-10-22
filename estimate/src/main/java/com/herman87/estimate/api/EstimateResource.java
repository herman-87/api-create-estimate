package com.herman87.estimate.api;

import com.herman87.estimate.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.EstimateApi;
import org.openapitools.model.EstimateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EstimateResource implements EstimateApi {
    private final EstimateService estimateService;


    @Override
    public ResponseEntity<Integer> createEstimate(EstimateDTO estimateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estimateService.createEstimate(estimateDTO));
    }
}
