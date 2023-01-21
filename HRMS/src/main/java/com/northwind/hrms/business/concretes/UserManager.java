package com.northwind.hrms.business.concretes;

import com.northwind.hrms.business.abstracts.UserService;
import com.northwind.hrms.core.utilities.results.DataResult;
import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.core.utilities.results.SuccessDataResult;
import com.northwind.hrms.core.utilities.results.SuccessResult;
import com.northwind.hrms.dataAccess.abstracts.UserDao;
import com.northwind.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("User added..");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>("User listed..", this.userDao.findAll());
    }
}
