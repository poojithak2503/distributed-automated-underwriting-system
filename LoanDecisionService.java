package com.poojitha.underwriting.service;

import com.poojitha.underwriting.model.Borrower;
import org.springframework.stereotype.Service;

@Service
public class LoanDecisionService {

    public String evaluateApplication(Borrower borrower) {

        int risk = borrower.getRiskScore();

        if (risk <= 25
                && borrower.getCreditScore() >= 760
                && borrower.getAnnualIncome() >= 90000) {

            borrower.setApplicationStatus("APPROVED");

            return "APPROVED";
        }

        if (risk <= 55
                && borrower.getCreditScore() >= 680) {

            borrower.setApplicationStatus("MANUAL_REVIEW");

            return "MANUAL_REVIEW";
        }

        borrower.setApplicationStatus("REJECTED");

        return "REJECTED";
    }

    public boolean eligibleForPremiumRate(Borrower borrower) {

        return borrower.getCreditScore() >= 780
                && borrower.getDebtToIncomeRatio() <= 0.30;
    }

    public boolean eligibleForHighValueLoan(Borrower borrower) {

        return borrower.getAnnualIncome() >= 150000
                && borrower.getCreditScore() >= 760;
    }

    public String recommendation(Borrower borrower) {

        if (eligibleForPremiumRate(borrower)) {
            return "Premium Interest Rate";
        }

        if (eligibleForHighValueLoan(borrower)) {
            return "High Value Mortgage";
        }

        return "Standard Mortgage";
    }

}
