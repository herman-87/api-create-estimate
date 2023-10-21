package com.herman87.estimate.domain.articles;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_article")
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "c_designation")
    private String designation;

    @Embedded
    private Price price;

    @Column(name = "c_created_at")
    @Builder.Default
    private LocalDateTime localDateTime = LocalDateTime.now();
}
