package com.northwind.hrms.api.controllers;

import com.northwind.hrms.business.abstracts.CandidateService;
import com.northwind.hrms.core.utilities.results.DataResult;
import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    private final CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate) throws Exception {
        return this.candidateService.add(candidate);
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }
}
