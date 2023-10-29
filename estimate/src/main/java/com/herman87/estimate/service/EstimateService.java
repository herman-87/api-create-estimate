package com.herman87.estimate.service;

import com.herman87.estimate.domain.documents.Estimate;
import com.herman87.estimate.dto.EstimateDTO;
import com.herman87.estimate.repository.EstimateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstimateService {
    private final EstimateRepository estimateRepository;

    @Transactional
    public Integer createEstimate(EstimateDTO estimateDTO) {
        return Optional.of(estimateDTO)
                .map(
                        estimateDTO1 ->
                                Estimate.builder()
                                        .title(estimateDTO.getTitle())
                                        .description(estimateDTO.getDescription())
                                        .build()
                ).map(estimateRepository::save)
                .map(Estimate::getId)
                .orElseThrow();
    }
}
