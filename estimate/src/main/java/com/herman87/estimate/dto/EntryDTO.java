package com.herman87.estimate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntryDTO {
    private Integer id;
    private String designation;
    private int quantity;
    private double unitPrice;
    private EstimateDTO estimateDTO;
}
