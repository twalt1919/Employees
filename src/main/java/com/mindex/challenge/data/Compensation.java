package com.mindex.challenge.data;

/**
 * The salary and effective date for each employee
 * @author twalt
 */
public class Compensation {
    private Employee employee;
    private int salary;
    private String effectiveDate;

    public Compensation() {}

    @Override
    public String toString() {
        return "Compensation{" + "employee=" + employee + ", salary=" + salary + ", effectiveDate=" + effectiveDate + '}';
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
