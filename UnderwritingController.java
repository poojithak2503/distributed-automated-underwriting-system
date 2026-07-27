package com.poojitha.underwriting.controller;

import com.poojitha.underwriting.model.Borrower;
import com.poojitha.underwriting.service.RiskAssessmentService;
import com.poojitha.underwriting.service.UnderwritingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/underwriting")
public class UnderwritingController {

    private final UnderwritingService underwritingService;
    private final RiskAssessmentService riskAssessmentService;

    public UnderwritingController(UnderwritingService underwritingService,
                                  RiskAssessmentService riskAssessmentService) {
        this.underwritingService = underwritingService;
        this.riskAssessmentService = riskAssessmentService;
    }

    @PostMapping("/submit")
    public Borrower submitApplication(@RequestBody Borrower borrower) {

        Borrower application =
                underwritingService.submitApplication(borrower);

        riskAssessmentService.processRiskAssessment(application);

        return application;
    }

    @GetMapping("/applications")
    public List<Borrower> getApplications() {
        return underwritingService.getApplications();
    }

    @GetMapping("/{applicationId}")
    public Optional<Borrower> getApplication(
            @PathVariable Long applicationId) {

        return underwritingService.getApplication(applicationId);
    }

    @GetMapping("/report")
    public String generateReport() {
        return underwritingService.underwritingReport();
    }

    @GetMapping("/approved")
    public long approvedApplications() {
        return underwritingService.approvedApplications();
    }

    @GetMapping("/rejected")
    public long rejectedApplications() {
        return underwritingService.rejectedApplications();
    }

    @GetMapping("/average-risk")
    public double averageRiskScore() {
        return underwritingService.averageRiskScore();
    }

    @DeleteMapping("/clear")
    public String clearApplications() {

        underwritingService.getApplications().clear();

        return "All mortgage applications have been removed.";

    }

}
