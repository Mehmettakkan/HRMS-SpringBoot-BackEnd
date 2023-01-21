package com.northwind.hrms.business.concretes;

import com.northwind.hrms.business.abstracts.JobPositionService;
import com.northwind.hrms.core.utilities.results.*;
import com.northwind.hrms.dataAccess.abstracts.JobPositionDao;
import com.northwind.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }


    @Override
    public Result add(JobPosition jobPosition) {
        if (!isPositionExist(jobPosition.getJobPosition()).isSuccess()) {
            return new ErrorResult("The job position already exist..");
        } else {
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult("Job position added..");
        }

    }

    public Result isPositionExist(String jobPosition) {

        if (this.jobPositionDao.findByJobPosition(jobPosition) == null) {
            return new SuccessResult();
        } else {
            return new ErrorResult();
        }

    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>("Job position listed..", this.jobPositionDao.findAll());
    }
}
