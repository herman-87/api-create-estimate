package com.herman87.estimate.service;

import com.herman87.estimate.domain.documents.Estimate;
import com.herman87.estimate.repository.EstimateRepository;
import com.herman87.estimate.service.mapper.EstimateMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.EstimateDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstimateService {
    private final EstimateMapper estimateMapper;
    private final EstimateRepository estimateRepository;

    @Transactional
    public Integer createEstimate(EstimateDTO estimateDTO) {
        return Optional.of(estimateDTO)
                .map(estimateMapper::fromEstimate)
                .map(estimateRepository::save)
                .map(Estimate::getId)
                .orElseThrow();
    }
}
