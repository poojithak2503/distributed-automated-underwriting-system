package com.poojitha.underwriting.service;

import com.poojitha.underwriting.model.Borrower;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PostgreSqlLockService {

    private final Map<Long, Object> applicationLocks =
            new ConcurrentHashMap<>();

    public void lockApplication(Borrower borrower) {

        Object lock = applicationLocks.computeIfAbsent(
                borrower.getApplicationId(),
                id -> new Object()
        );

        synchronized (lock) {

            System.out.println("--------------------------------");
            System.out.println("Pessimistic Lock Acquired");
            System.out.println("Application Id : "
                    + borrower.getApplicationId());

            borrower.setApplicationStatus("UNDER_REVIEW");

            System.out.println("Borrower Locked Successfully");
            System.out.println("--------------------------------");

        }

    }

    public void releaseLock(Long applicationId) {

        applicationLocks.remove(applicationId);

        System.out.println(
                "Lock Released : " + applicationId);

    }

    public boolean isLocked(Long applicationId) {

        return applicationLocks.containsKey(applicationId);

    }

    public int activeLocks() {

        return applicationLocks.size();

    }

}
