package com.northwind.hrms.business.concretes;

import com.northwind.hrms.business.abstracts.EmployerService;
import com.northwind.hrms.core.utilities.results.*;
import com.northwind.hrms.core.utilities.validations.EmailWebAddressValidator;
import com.northwind.hrms.core.utilities.verifications.abstracts.EmailVerificationService;
import com.northwind.hrms.core.utilities.verifications.abstracts.HrmsApproveService;
import com.northwind.hrms.dataAccess.abstracts.EmployerDao;
import com.northwind.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private final EmployerDao employerDao;
    private final EmailVerificationService emailVerification;
    private final HrmsApproveService hrmsApprove;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerification, HrmsApproveService hrmsApprove) {
        this.employerDao = employerDao;
        this.emailVerification = emailVerification;
        this.hrmsApprove = hrmsApprove;
    }


    @Override
    public Result add(Employer employer)  {
        if (!this.emailVerification.verifyEmail(employer.getEmail()).isSuccess()) {
            return new ErrorResult("Email could not be verified..");
        }
        if (!this.hrmsApprove.isApproved(employer).isSuccess()) {
            return new ErrorResult("Hrms approve validation failed...");
        }
        if (!isEmailExist(employer.getEmail()).isSuccess()) {
            return new ErrorResult("This email already exist..");
        }
        Result result = EmailWebAddressValidator.valid(employer.getEmail(), employer.getWebAddress());
        if (!result.isSuccess()) {
            return new ErrorResult(result.getMessage());
        }
        this.employerDao.save(employer);
        return new SuccessResult("Employer added..");
    }

    public Result isEmailExist(String email) {
        if (this.employerDao.findByEmail(email) == null) {
            return new SuccessResult();
        } else {
            return new ErrorResult();
        }
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>("Employer listed..", this.employerDao.findAll());
    }
}
