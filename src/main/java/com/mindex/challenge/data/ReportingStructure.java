package com.mindex.challenge.data;

/**
 * The organization hierarchy details for each employee
 * @author twalt
 */
public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    public ReportingStructure() {}

    @Override
    public String toString() {
        return "ReportingStructure{" + "employee=" + employee + ", numberOfReports=" + numberOfReports + '}';
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the numberOfReports
     */
    public int getNumberOfReports() {
        return numberOfReports;
    }

    /**
     * @param numberOfReports the numberOfReports to set
     */
    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
