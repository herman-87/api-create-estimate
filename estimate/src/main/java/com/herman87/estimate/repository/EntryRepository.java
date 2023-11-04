package com.herman87.estimate.repository;

import com.herman87.estimate.domain.documents.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer> {
    List<Entry> findAllByEstimateId(int estimateId);
}
