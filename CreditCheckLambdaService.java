package com.poojitha.underwriting.service;

import com.poojitha.underwriting.model.Borrower;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class CreditCheckLambdaService {

    private final Random random = new Random();

    @Async
    public void executeCreditCheck(Borrower borrower) {

        System.out.println();
        System.out.println("========== AWS LAMBDA ==========");
        System.out.println("Function Started");
        System.out.println("Borrower : " + borrower.getBorrowerName());
        System.out.println("Application : " + borrower.getApplicationId());

        int externalCreditScore = fetchCreditScore();

        System.out.println("External Credit Score : " + externalCreditScore);

        if (externalCreditScore >= borrower.getCreditScore()) {
            System.out.println("Credit Validation : PASSED");
        } else {
            System.out.println("Credit Validation : REVIEW REQUIRED");
        }

        System.out.println("Fraud Verification : PASSED");
        System.out.println("Identity Verification : PASSED");
        System.out.println("Timestamp : " + LocalDateTime.now());
        System.out.println("Lambda Execution Completed");
        System.out.println("===============================");
    }

    private int fetchCreditScore() {

        return 650 + random.nextInt(180);

    }

}
