package com.herman87.estimate.repository;

import com.herman87.estimate.domain.documents.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstimateRepository extends JpaRepository<Estimate, Integer> {
}
