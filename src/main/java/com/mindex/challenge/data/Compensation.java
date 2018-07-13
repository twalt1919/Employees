package com.mindex.challenge.data;

/**
 * The salary and effective date for each employee
 * @author Tom Walters
 */
public class Compensation {
    private String employeeId;
    private int salary;
    private String effectiveDate;

    public Compensation() {}

    @Override
    public String toString() {
        return "Compensation{" + "employeeId=" + employeeId + ", salary=" + salary + ", effectiveDate=" + effectiveDate + '}';
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
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * @return the effectiveDate
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * @param effectiveDate the effectiveDate to set
     */
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
