package com.herman87.estimate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryDTO {
    private Integer id;
    private String designation;
    private int quantity;
    private double unitPrice;
    private double total;
    private EstimateDTO estimateDTO;
}
