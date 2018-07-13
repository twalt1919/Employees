package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {

    private String reportingStructureUrl;
    private String reportingStructureIdUrl;

    @Autowired
    private ReportingStructureService reportingStructureService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        reportingStructureUrl = "http://localhost:" + port + "/reportingStructure";
        reportingStructureIdUrl = "http://localhost:" + port + "/reportingStructure/{id}";
    }

    @Test
    public void testCreateReadUpdate() {
        ReportingStructure testReportingStructure = new ReportingStructure();
        testReportingStructure.setNumberOfReports(1013);

        // Create checks
        ReportingStructure createdReportingStructure = restTemplate.postForEntity(reportingStructureUrl, testReportingStructure, ReportingStructure.class).getBody();
        assertNotNull(createdReportingStructure.getEmployeeId());
        assertReportingStructureEquivalence(testReportingStructure, createdReportingStructure);


        // Read checks
        ReportingStructure readReportingStructure = restTemplate.getForEntity(reportingStructureIdUrl, ReportingStructure.class, createdReportingStructure.getEmployeeId()).getBody();
        assertEquals(createdReportingStructure.getEmployeeId(), readReportingStructure.getEmployeeId());
        assertReportingStructureEquivalence(createdReportingStructure, readReportingStructure);


        // Update checks
        readReportingStructure.setNumberOfReports(1013);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ReportingStructure updatedReportingStructure =
                restTemplate.exchange(reportingStructureIdUrl,
                        HttpMethod.PUT,
                        new HttpEntity<ReportingStructure>(readReportingStructure, headers),
                        ReportingStructure.class,
                        readReportingStructure.getEmployeeId()).getBody();

        assertReportingStructureEquivalence(readReportingStructure, updatedReportingStructure);
    }

    private static void assertReportingStructureEquivalence(ReportingStructure expected, ReportingStructure actual) {
        assertEquals(expected.getNumberOfReports(), actual.getNumberOfReports());
    }
}
