package com.herman87.estimate.api;

import com.herman87.estimate.dto.EntryDTO;
import com.herman87.estimate.dto.EstimateDTO;
import com.herman87.estimate.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EstimateResource {
    private final EstimateService estimateService;


    @PostMapping("/estimate")
    public ResponseEntity<Integer> createEstimate(@RequestBody EstimateDTO estimateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estimateService.createEstimate(estimateDTO));
    }

    @GetMapping("/estimate")
    public ResponseEntity<List<EstimateDTO>> getAllEstimates() {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.fetchAllEstimate());
    }

    @GetMapping("/estimate/{id}")
    public ResponseEntity<EstimateDTO> getEstimateById(@PathVariable("id") int estimateId) {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.fetchEstimateById(estimateId));
    }

    @DeleteMapping("/estimate/{id}")
    public ResponseEntity<Void> deleteEstimateById(@PathVariable("id") int estimateId) {
        estimateService.deleteEstimateById(estimateId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/estimate/{id}/entries")
    public ResponseEntity<Void> addEntriesInEstimateBy(@PathVariable("id") int estimateId, @RequestBody List<EntryDTO> entryDTOList) {
        estimateService.addEntries(estimateId, entryDTOList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/entry/{id}")
    public ResponseEntity<EntryDTO> getEntryById(@PathVariable("id") int entryId) {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.fetchEntryById(entryId));
    }
    @GetMapping("/estimate/{id}/entries")
    public ResponseEntity<List<EntryDTO>> getEntriesByEstimate(@PathVariable("id") int estimateId) {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.getAllEntriesByEstimateId(estimateId));
    }

    @DeleteMapping("/entry/{id}")
    public ResponseEntity<Void> deleteEntryById(@PathVariable("id") int entryId) {
        estimateService.deleteEntryById(entryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
