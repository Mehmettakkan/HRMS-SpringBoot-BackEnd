package com.northwind.hrms.core.utilities.verifications.concretes;

import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.core.utilities.results.SuccessResult;
import com.northwind.hrms.core.utilities.verifications.abstracts.EmailVerificationService;
import org.springframework.stereotype.Service;

@Service //Servis işlemi gören böyle classlara bu anotasyonu vermezsen hata fırlatır
public class EmailVerificationManager implements EmailVerificationService {
    @Override
    public Result verifyEmail(String email) {
        return new SuccessResult();
    }
}
