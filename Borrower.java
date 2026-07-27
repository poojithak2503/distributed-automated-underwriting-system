package com.poojitha.underwriting.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Borrower {

    private Long applicationId;
    private String borrowerName;
    private String ssn;
    private double annualIncome;
    private int creditScore;
    private double requestedLoanAmount;
    private int loanTermMonths;
    private String employmentStatus;
    private String loanPurpose;
    private String applicationStatus;
    private double debtToIncomeRatio;
    private int riskScore;
    private LocalDateTime applicationDate;

    public Borrower() {
    }

    public Borrower(Long applicationId,
                    String borrowerName,
                    String ssn,
                    double annualIncome,
                    int creditScore,
                    double requestedLoanAmount,
                    int loanTermMonths,
                    String employmentStatus,
                    String loanPurpose) {

        this.applicationId = applicationId;
        this.borrowerName = borrowerName;
        this.ssn = ssn;
        this.annualIncome = annualIncome;
        this.creditScore = creditScore;
        this.requestedLoanAmount = requestedLoanAmount;
        this.loanTermMonths = loanTermMonths;
        this.employmentStatus = employmentStatus;
        this.loanPurpose = loanPurpose;
        this.applicationStatus = "SUBMITTED";
        this.applicationDate = LocalDateTime.now();

        calculateDebtToIncomeRatio();
    }

    public void calculateDebtToIncomeRatio() {

        if (annualIncome == 0) {
            debtToIncomeRatio = 0;
            return;
        }

        debtToIncomeRatio =
                requestedLoanAmount / annualIncome;

    }

    public boolean isHighRisk() {
        return riskScore >= 75;
    }

    public boolean isGoodCredit() {
        return creditScore >= 700;
    }

    public boolean isEligibleIncome() {
        return annualIncome >= 50000;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
        calculateDebtToIncomeRatio();
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public double getRequestedLoanAmount() {
        return requestedLoanAmount;
    }

    public void setRequestedLoanAmount(double requestedLoanAmount) {
        this.requestedLoanAmount = requestedLoanAmount;
        calculateDebtToIncomeRatio();
    }

    public int getLoanTermMonths() {
        return loanTermMonths;
    }

    public void setLoanTermMonths(int loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public double getDebtToIncomeRatio() {
        return debtToIncomeRatio;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "applicationId=" + applicationId +
                ", borrowerName='" + borrowerName + '\'' +
                ", creditScore=" + creditScore +
                ", annualIncome=" + annualIncome +
                ", requestedLoanAmount=" + requestedLoanAmount +
                ", debtToIncomeRatio=" + debtToIncomeRatio +
                ", riskScore=" + riskScore +
                ", applicationStatus='" + applicationStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof Borrower)) {
            return false;
        }

        Borrower borrower = (Borrower) object;

        return Objects.equals(applicationId,
                borrower.applicationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId);
    }

}
