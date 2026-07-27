package com.poojitha.underwriting.service;

import com.poojitha.underwriting.model.Borrower;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RiskAssessmentService {

    @Async
    public void processRiskAssessment(Borrower borrower) {

        System.out.println("-------------------------------------------");
        System.out.println("AWS Lambda Risk Assessment Started");
        System.out.println("Borrower : " + borrower.getBorrowerName());

        validateIncome(borrower);

        validateCreditHistory(borrower);

        validateDebtRatio(borrower);

        generateRiskCategory(borrower);

        System.out.println("Completed : " + LocalDateTime.now());
        System.out.println("-------------------------------------------");
    }

    private void validateIncome(Borrower borrower) {

        if (borrower.getAnnualIncome() >= 80000) {

            System.out.println("Income Verification : PASSED");

        } else {

            System.out.println("Income Verification : REVIEW");

        }

    }

    private void validateCreditHistory(Borrower borrower) {

        if (borrower.getCreditScore() >= 700) {

            System.out.println("Credit History : GOOD");

        } else if (borrower.getCreditScore() >= 650) {

            System.out.println("Credit History : AVERAGE");

        } else {

            System.out.println("Credit History : POOR");

        }

    }

    private void validateDebtRatio(Borrower borrower) {

        if (borrower.getDebtToIncomeRatio() <= 0.35) {

            System.out.println("Debt Ratio : ACCEPTABLE");

        } else {

            System.out.println("Debt Ratio : HIGH");

        }

    }

    private void generateRiskCategory(Borrower borrower) {

        if (borrower.getRiskScore() <= 30) {

            System.out.println("Risk Category : LOW");

        } else if (borrower.getRiskScore() <= 60) {

            System.out.println("Risk Category : MEDIUM");

        } else {

            System.out.println("Risk Category : HIGH");

        }

    }

}
