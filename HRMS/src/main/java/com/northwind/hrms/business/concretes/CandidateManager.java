package com.northwind.hrms.business.concretes;

import com.northwind.hrms.business.abstracts.CandidateService;
import com.northwind.hrms.core.utilities.adapters.abstracts.PersonCheckService;
import com.northwind.hrms.core.utilities.results.*;
import com.northwind.hrms.core.utilities.validations.PasswordValidator;
import com.northwind.hrms.core.utilities.verifications.abstracts.EmailVerificationService;
import com.northwind.hrms.dataAccess.abstracts.CandidateDao;
import com.northwind.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;
    private final PersonCheckService personCheckService;
    private final EmailVerificationService emailVerificationService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, PersonCheckService personCheckService, EmailVerificationService emailVerificationService) {
        this.candidateDao = candidateDao;
        this.personCheckService = personCheckService;
        this.emailVerificationService = emailVerificationService;
    }


    @Override
    public Result add(Candidate candidate) throws Exception {
        if (!this.personCheckService.checkIfRealPerson(candidate).isSuccess()) {
            return new ErrorResult("Not a valid person. Please check the given info..");
        }
        if (!(this.isEmailExist(candidate.getEmail()).isSuccess() || this.isIdentityNumberExist(candidate.getIdentityNumber()).isSuccess())) {
            return new ErrorResult("This email or ID number already exists..");
        }
        if (!this.emailVerificationService.verifyEmail(candidate.getEmail()).isSuccess()) {
            return new ErrorResult("Email verify unsuccess..");
        }
        Result result = PasswordValidator.valid(candidate.getPassword(), candidate.getRepeatPassword());
        if (!result.isSuccess()) {
            return new ErrorResult(result.getMessage());
        }
        this.candidateDao.save(candidate);
        return new SuccessResult("Candidate added..");
    }

    public Result isEmailExist(String email) {
        if (this.candidateDao.findByEmail(email) == null) {
            return new SuccessResult();
        } else {
            return new ErrorResult();
        }
    }

    public Result isIdentityNumberExist(String identityNumber) {
        if (this.candidateDao.findByIdentityNumber(identityNumber) == null) {
            return new SuccessResult();
        } else {
            return new ErrorResult();
        }
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<>("Candidate listed..", this.candidateDao.findAll());
    }
}
