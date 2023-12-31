package com.herman87.estimate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstimateDTO {
    private int id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private List<EntryDTO> entryDTOList;
}
