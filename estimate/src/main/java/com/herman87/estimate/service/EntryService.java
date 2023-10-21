package com.herman87.estimate.service;

import com.herman87.estimate.repository.EntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntryService {
    private final EntryRepository entryRepository;

}
