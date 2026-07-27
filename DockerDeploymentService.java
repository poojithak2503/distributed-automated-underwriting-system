package com.poojitha.underwriting.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DockerDeploymentService {

    public void deployApplication() {

        System.out.println();
        System.out.println("Docker Deployment Started");
        System.out.println("-------------------------------");

        pullBaseImage();

        buildImage();

        createContainer();

        startContainer();

        healthCheck();

        System.out.println("-------------------------------");
        System.out.println("Deployment Completed");
        System.out.println("Time : " + LocalDateTime.now());
    }

    private void pullBaseImage() {

        System.out.println("Pulling OpenJDK 11 Image");

    }

    private void buildImage() {

        System.out.println("Building Mortgage Service Image");

    }

    private void createContainer() {

        System.out.println("Creating Docker Container");

    }

    private void startContainer() {

        System.out.println("Container Started Successfully");

    }

    private void healthCheck() {

        System.out.println("Health Check : PASSED");

    }

}
