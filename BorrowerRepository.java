package com.poojitha.underwriting.repository;

import com.poojitha.underwriting.model.Borrower;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class BorrowerRepository {

    private final List<Borrower> database = new ArrayList<>();

    public Borrower save(Borrower borrower) {

        database.add(borrower);

        return borrower;
    }

    public List<Borrower> findAll() {

        return new ArrayList<>(database);

    }

    public Optional<Borrower> findById(Long applicationId) {

        return database.stream()
                .filter(application ->
                        application.getApplicationId().equals(applicationId))
                .findFirst();

    }

    public List<Borrower> findApprovedApplications() {

        return database.stream()
                .filter(application ->
                        "APPROVED".equalsIgnoreCase(
                                application.getApplicationStatus()))
                .toList();

    }

    public List<Borrower> findRejectedApplications() {

        return database.stream()
                .filter(application ->
                        "REJECTED".equalsIgnoreCase(
                                application.getApplicationStatus()))
                .toList();

    }

    public Optional<Borrower> highestRiskBorrower() {

        return database.stream()
                .max(Comparator.comparingInt(
                        Borrower::getRiskScore));

    }

    public void deleteAll() {

        database.clear();

    }

    public int totalApplications() {

        return database.size();

    }

}
