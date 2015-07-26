package com.unep.wcmc.service;

import com.unep.wcmc.integration.JobRunner;
import com.unep.wcmc.model.IntegrationHistory;
import com.unep.wcmc.model.IntegrationSource.Source;
import com.unep.wcmc.repository.IntegrationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class IntegrationService {

    @Autowired
    private JobRunner jobRunner;

    @Autowired
    private IntegrationHistoryRepository historyRepository;

    public void start(Source source) throws Exception {
        jobRunner.start(source.name());
    }

    public void stop(Source source) throws Exception {
        jobRunner.stop(source.name());
    }

    public IntegrationHistory findLatestHistory(Source source) {
        return historyRepository.findFirstByIntegrationSourceSourceOrderByUpdatedAtDesc(source);
    }

    public List<IntegrationHistory> findAllLatestHistory() {
        List<IntegrationHistory> result = new ArrayList<>();
        IntegrationHistory history = findLatestHistory(Source.SPECIES_PLUS);
        if (history != null) {
            result.add(history);
        }
        history = findLatestHistory(Source.FLORA);
        if (history != null) {
            result.add(history);
        }
        history = findLatestHistory(Source.FAUNA);
        if (history != null) {
            result.add(history);
        }
        return result;
    }

}
