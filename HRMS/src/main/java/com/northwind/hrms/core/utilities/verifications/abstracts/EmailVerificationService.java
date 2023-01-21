package com.northwind.hrms.core.utilities.verifications.abstracts;

import com.northwind.hrms.core.utilities.results.Result;

public interface EmailVerificationService {
    public Result verifyEmail(String email);
}
