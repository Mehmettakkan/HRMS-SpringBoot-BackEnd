package com.northwind.hrms.core.utilities.verifications.concretes;

import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.core.utilities.results.SuccessResult;
import com.northwind.hrms.core.utilities.verifications.abstracts.HrmsApproveService;
import com.northwind.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class HrmsApproveManager implements HrmsApproveService {

    @Override
    public Result isApproved(User user) {
        return new SuccessResult();
    }
}
