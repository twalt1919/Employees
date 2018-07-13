package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.ReportingStructureRepository;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * The thin wrapper between the end-points and the data "repository"
 * @author Tom Walters
 *
 */
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private ReportingStructureRepository reportingStructureRepository;

    @Override
    public ReportingStructure create(ReportingStructure reportingStructure) {
        LOG.debug("Creating reportingStructure [{}]", reportingStructure);

        reportingStructure.setEmployeeId(UUID.randomUUID().toString());
        reportingStructureRepository.insert(reportingStructure);

        return reportingStructure;
    }

    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating reportingStructure with employeeId [{}]", id);

        ReportingStructure reportingStructure = reportingStructureRepository.findByEmployeeId(id);

        if (reportingStructure == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return reportingStructure;
    }

    @Override
    public ReportingStructure update(ReportingStructure reportingStructure) {
        LOG.debug("Updating reportingStructure [{}]", reportingStructure);

        return reportingStructureRepository.save(reportingStructure);
    }
}
