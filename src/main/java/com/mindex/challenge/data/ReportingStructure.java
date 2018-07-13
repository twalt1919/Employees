package com.mindex.challenge.data;

/**
 * The organization hierarchy details for each employee
 * @author Tom Walters
 */
public class ReportingStructure {
    private String employeeId;
    private int numberOfReports;

    public ReportingStructure() {}

    @Override
    public String toString() {
        return "ReportingStructure{" + "employeeId=" + employeeId + ", numberOfReports=" + numberOfReports + '}';
    }

    /**
     * @return the employee Id
     */
    public String getEmployeeId() {
		return employeeId;
	}

    /**
     * @param employeeId the employeeId to set
     */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
