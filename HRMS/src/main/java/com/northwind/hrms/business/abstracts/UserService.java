package com.northwind.hrms.business.abstracts;

import com.northwind.hrms.core.utilities.results.DataResult;
import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<List<User>> getAll();
}
