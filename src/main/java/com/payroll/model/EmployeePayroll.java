package com.payroll.model;

import java.math.BigDecimal;

/**
 * Core Entity representing structured compensation calculations.
 * Designed to ensure atomic calculations for payroll processing.
 */
public class EmployeePayroll {
    private Long employeeId;
    private String employeeName;
    private BigDecimal baseSalary;
    private BigDecimal allowance;
    private BigDecimal taxDeduction;
    private BigDecimal netPayableSalary;

    // Default Constructor
    public EmployeePayroll() {}

    // Business Logic Method: Computes Net Salary and enforces constraints
    public void calculateNetPayable() {
        if (this.baseSalary == null) {
            this.baseSalary = BigDecimal.ZERO;
        }
        if (this.allowance == null) {
            this.allowance = BigDecimal.ZERO;
        }
        
        // Basic Enterprise Slab Calculation (Simulated 12% TDS Deduction)
        BigDecimal grossPay = this.baseSalary.add(this.allowance);
        this.taxDeduction = grossPay.multiply(new BigDecimal("0.12"));
        this.netPayableSalary = grossPay.subtract(this.taxDeduction);
    }

    // Getters and Setters
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public BigDecimal getBaseSalary() { return baseSalary; }
    public void setBaseSalary(BigDecimal baseSalary) { this.baseSalary = baseSalary; }
    public BigDecimal getNetPayableSalary() { return netPayableSalary; }
}
