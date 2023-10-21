package com.herman87.estimate.domain.documents;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_estimate")
public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "c_title")
    private String title;

    @Column(name = "c_description")
    private String description;

    @Builder.Default
    @Column(name = "c_created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    @OneToMany(mappedBy = "estimate", fetch = FetchType.LAZY)
    private List<Entry> entries = new ArrayList<>();

    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }
}
