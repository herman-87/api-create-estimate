package com.herman87.estimate.domain.documents;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "c_designation")
    private String designation;

    @Column(name = "c_quantity")
    private int quantity;

    @Column(name = "c_unit_price")
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "c_estimate", referencedColumnName = "c_id")
    private Estimate estimate;
}
