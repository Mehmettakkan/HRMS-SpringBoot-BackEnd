package com.northwind.hrms.core.utilities.adapters.abstracts;

import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.entities.concretes.Candidate;

public interface PersonCheckService {
    public Result checkIfRealPerson(Candidate candidate) throws Exception;
}
