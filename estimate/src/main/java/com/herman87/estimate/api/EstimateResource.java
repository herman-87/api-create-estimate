package com.herman87.estimate.api;

import com.herman87.estimate.dto.EstimateDTO;
import com.herman87.estimate.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EstimateResource {
    private final EstimateService estimateService;


    @PostMapping("/estimate")
    public ResponseEntity<Integer> createEstimate(@RequestBody EstimateDTO estimateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estimateService.createEstimate(estimateDTO));
    }
}
