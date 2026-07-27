package com.poojitha.underwriting.service;

import com.poojitha.underwriting.model.Borrower;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UnderwritingService {

    private final List<Borrower> borrowers = new ArrayList<>();

    public Borrower submitApplication(Borrower borrower) {

        borrower.setRiskScore(calculateRiskScore(borrower));

        borrower.setApplicationStatus(
                determineDecision(borrower)
        );

        borrowers.add(borrower);

        return borrower;
    }

    public int calculateRiskScore(Borrower borrower) {

        int score = 0;

        if (borrower.getCreditScore() >= 800) {
            score += 10;
        } else if (borrower.getCreditScore() >= 700) {
            score += 20;
        } else if (borrower.getCreditScore() >= 650) {
            score += 40;
        } else {
            score += 70;
        }

        if (borrower.getAnnualIncome() < 50000) {
            score += 20;
        }

        if (borrower.getDebtToIncomeRatio() > 0.40) {
            score += 20;
        }

        if ("UNEMPLOYED".equalsIgnoreCase(
                borrower.getEmploymentStatus())) {
            score += 25;
        }

        return Math.min(score, 100);
    }

    public String determineDecision(Borrower borrower) {

        int risk = borrower.getRiskScore();

        if (risk <= 30) {
            return "APPROVED";
        }

        if (risk <= 60) {
            return "MANUAL_REVIEW";
        }

        return "REJECTED";
    }

    public List<Borrower> getApplications() {
        return borrowers;
    }

    public Optional<Borrower> getApplication(Long id) {

        return borrowers.stream()
                .filter(application ->
                        application.getApplicationId().equals(id))
                .findFirst();
    }

    public long approvedApplications() {

        return borrowers.stream()
                .filter(application ->
                        "APPROVED".equals(
                                application.getApplicationStatus()))
                .count();
    }

    public long rejectedApplications() {

        return borrowers.stream()
                .filter(application ->
                        "REJECTED".equals(
                                application.getApplicationStatus()))
                .count();
    }

    public double averageRiskScore() {

        return borrowers.stream()
                .mapToInt(Borrower::getRiskScore)
                .average()
                .orElse(0);

    }

    public Optional<Borrower> highestRiskApplication() {

        return borrowers.stream()
                .max(Comparator.comparingInt(
                        Borrower::getRiskScore));

    }

    public String underwritingReport() {

        StringBuilder report = new StringBuilder();

        report.append("Mortgage Underwriting Report\n");
        report.append("----------------------------------\n");
        report.append("Generated : ")
                .append(LocalDateTime.now())
                .append("\n");
        report.append("Applications : ")
                .append(borrowers.size())
                .append("\n");
        report.append("Approved : ")
                .append(approvedApplications())
                .append("\n");
        report.append("Rejected : ")
                .append(rejectedApplications())
                .append("\n");
        report.append("Average Risk Score : ")
                .append(averageRiskScore())
                .append("\n");

        highestRiskApplication().ifPresent(application ->
                report.append("Highest Risk Borrower : ")
                        .append(application.getBorrowerName())
                        .append("\n"));

        return report.toString();
    }

}
