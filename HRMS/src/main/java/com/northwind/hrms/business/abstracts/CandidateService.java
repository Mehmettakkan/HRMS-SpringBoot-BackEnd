package com.northwind.hrms.business.abstracts;

import com.northwind.hrms.core.utilities.results.DataResult;
import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {

    Result add(Candidate candidate) throws Exception;
    DataResult<List<Candidate>> getAll();
}
