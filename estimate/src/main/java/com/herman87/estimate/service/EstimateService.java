package com.herman87.estimate.service;

import com.herman87.estimate.domain.documents.Entry;
import com.herman87.estimate.domain.documents.Estimate;
import com.herman87.estimate.domain.dto.EntryDTO;
import com.herman87.estimate.domain.dto.EstimateDTO;
import com.herman87.estimate.repository.EntryRepository;
import com.herman87.estimate.repository.EstimateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EstimateService {
    private final EstimateRepository estimateRepository;
    private final EntryRepository entryRepository;

    @Transactional
    public Integer create(EstimateDTO estimateDTO) {
        return estimateRepository.save(
                Estimate.builder()
                        .title(estimateDTO.getTitle())
                        .description(estimateDTO.getDescription())
                        .build()
        )
                .getId();
    }

    @Transactional
    public Estimate getEstimateById(Integer id) {
        return estimateRepository.findById(id).orElseThrow(null);
    }

    @Transactional
    public void deleteEstimateById(Integer estimateId) {
        estimateRepository.deleteById(estimateId);
    }

    @Transactional
    public Integer addNewEntry(Integer estimateId, EntryDTO entryDTO) {
        Estimate estimate = estimateRepository.findById(estimateId).orElseThrow();
        Entry entry = Entry.builder()
                .designation(entryDTO.getDesignation())
                .quantity(entryDTO.getQuantity())
                .unitPrice(entryDTO.getUnitPrice())
                .estimate(estimate)
                .build();

        estimate.addEntry(entry);

        Entry savedEstimate = entryRepository.save(entry);
        return savedEstimate.getId();
    }

    @Transactional
    public void deleteEntryById(Integer entryId) {
        entryRepository.deleteById(entryId);
    }

    @Transactional
    public List<Estimate> getAllEstimate() {
        return estimateRepository.findAll();
    }

    @Transactional
    public Entry getEntryById(Integer id) {
        Entry entry = entryRepository.findById(id).orElseThrow(null);
        if (Objects.isNull(entry.getId())) {
            return Entry.builder()
                    .id(entry.getId())
                    .designation(entry.getDesignation())
                    .quantity(entry.getQuantity())
                    .unitPrice(entry.getUnitPrice())
                    .estimate(null)
                    .build();
        }
        return Entry.builder()
                .id(entry.getId())
                .designation(entry.getDesignation())
                .quantity(entry.getQuantity())
                .unitPrice(entry.getUnitPrice())
                .estimate(
                        Estimate.builder()
                                .id(entry.getEstimate().getId())
                                .title(entry.getEstimate().getTitle())
                                .description(entry.getEstimate().getDescription())
                                .localDateTime(entry.getEstimate().getLocalDateTime())
                                .build()
                )
                .build();


    }
}
