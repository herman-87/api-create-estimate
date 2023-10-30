package com.herman87.estimate.service;

import com.herman87.estimate.domain.documents.Entry;
import com.herman87.estimate.domain.documents.Estimate;
import com.herman87.estimate.dto.EntryDTO;
import com.herman87.estimate.dto.EstimateDTO;
import com.herman87.estimate.repository.EntryRepository;
import com.herman87.estimate.repository.EstimateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstimateService {
    private final EstimateRepository estimateRepository;
    private final EntryRepository entryRepository;

    private static EstimateDTO toEstimateDTO(Estimate estimate) {
        return EstimateDTO.builder()
                .id(estimate.getId())
                .title(estimate.getTitle())
                .description(estimate.getDescription())
                .createdAt(estimate.getCreatedAt())
                .build();
    }

    private static Entry fromEntry(EntryDTO entryDTO, Estimate estimate) {
        return Entry.builder()
                .estimate(estimate)
                .quantity(entryDTO.getQuantity())
                .designation(entryDTO.getDesignation())
                .unitPrice(entryDTO.getUnitPrice())
                .build();
    }

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

    @Transactional
    public List<EstimateDTO> fetchAllEstimate() {
        return estimateRepository.findAll()
                .stream()
                .map(EstimateService::toEstimateDTO)
                .toList();
    }

    @Transactional
    public EstimateDTO fetchEstimateById(int estimateId) {
        return Optional.of(estimateId)
                .flatMap(estimateRepository::findById)
                .map(EstimateService::toEstimateDTO)
                .orElse(null);
    }

    @Transactional
    public void deleteEstimateById(int estimateId) {
        Optional.of(estimateId).ifPresent(estimateRepository::deleteById);
    }

    @Transactional
    public void addEntries(int estimateId, List<EntryDTO> entryDTOList) {
        Estimate estimate = estimateRepository.findById(estimateId).orElseThrow();

        List<Entry> entryList = entryDTOList.stream()
                .map(entryDTO -> fromEntry(entryDTO, estimate))
                .toList();

        estimate.addEntries(entryList);

        estimateRepository.save(estimate);
    }

    @Transactional
    public EntryDTO fetchEntryById(int entryId) {
        return Optional.of(entryId)
                .flatMap(entryRepository::findById)
                .map(
                        entry -> EntryDTO.builder()
                                .id(entry.getId())
                                .quantity(entry.getQuantity())
                                .unitPrice(entry.getUnitPrice())
                                .designation(entry.getDesignation())
                                .build()
                )
                .orElseThrow();
    }

    @Transactional
    public void deleteEntryById(int entryId) {
        Optional.of(entryId).ifPresent(entryRepository::deleteById);
    }
}
