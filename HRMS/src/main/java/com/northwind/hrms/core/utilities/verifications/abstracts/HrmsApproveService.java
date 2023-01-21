package com.northwind.hrms.core.utilities.verifications.abstracts;

import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.entities.concretes.User;

public interface HrmsApproveService {
    public Result isApproved(User user);
}
