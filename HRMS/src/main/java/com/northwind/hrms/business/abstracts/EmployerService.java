package com.northwind.hrms.business.abstracts;

import com.northwind.hrms.core.utilities.results.DataResult;
import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    Result add(Employer employer);
    DataResult<List<Employer>> getAll();
}
