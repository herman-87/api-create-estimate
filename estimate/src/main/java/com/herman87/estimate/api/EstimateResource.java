package com.herman87.estimate.api;

import com.herman87.estimate.domain.documents.Entry;
import com.herman87.estimate.domain.documents.Estimate;
import com.herman87.estimate.domain.dto.EntryDTO;
import com.herman87.estimate.domain.dto.EstimateDTO;
import com.herman87.estimate.service.EstimateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstimateResource {
    @Autowired
    private EstimateService estimateService;

//    estimate endpoint
    @GetMapping("/estimate")
    public ResponseEntity<List<Estimate>> getEstimateById() {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.getAllEstimate());
    }

    @GetMapping("/estimate/{id}")
    public ResponseEntity<Estimate> getEstimateById(@PathVariable("id") final Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.getEstimateById(id));
    }

    @PostMapping("/estimate")
    public ResponseEntity<Integer> createEstimate(@RequestBody EstimateDTO estimateDTO) {
         return ResponseEntity.status(HttpStatus.CREATED).body(estimateService.create(estimateDTO));
    }

    @DeleteMapping("/estimate/{id}")
    public ResponseEntity<Void> deleteEstimateById(@PathVariable("id") Integer estimateId) {
        estimateService.deleteEstimateById(estimateId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // entry end point
    @GetMapping("/entry/{id}")
    public ResponseEntity<Entry> getEntryById(@PathVariable("id") final Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.getEntryById(id));
    }

    @PostMapping("/estimate/{estimateId}/entry")
    public ResponseEntity<Integer> addNewEntry(
            @PathVariable("estimateId") final Integer estimateId,
            @RequestBody EntryDTO entryDTO
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(estimateService.addNewEntry(estimateId, entryDTO));
    }

    @DeleteMapping("/entry/{id}")
    public ResponseEntity<Void> deleteEntryById(@PathVariable("id") Integer entryId) {
        estimateService.deleteEntryById(entryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
