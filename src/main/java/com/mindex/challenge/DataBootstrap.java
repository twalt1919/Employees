package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.dao.ReportingStructureRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

@Component
public class DataBootstrap {
    private static final String COMPENSATION_LOCATION = "/static/compensation_database.json";
    private static final String EMPLOYEE_LOCATION = "/static/employee_database.json";

    @Autowired
    private CompensationRepository compensationRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        InputStream inputStreamCompensation = this.getClass().getResourceAsStream(COMPENSATION_LOCATION);
        InputStream inputStreamEmployee = this.getClass().getResourceAsStream(EMPLOYEE_LOCATION);

        Compensation[] compensations = null;
        Employee[] employees = null;

        try {
        	compensations = objectMapper.readValue(inputStreamCompensation, Compensation[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            employees = objectMapper.readValue(inputStreamEmployee, Employee[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Compensation compensation : compensations) {
        	compensationRepository.insert(compensation);
        }
        for (Employee employee : employees) {
            employeeRepository.insert(employee);
        }
    }
}
