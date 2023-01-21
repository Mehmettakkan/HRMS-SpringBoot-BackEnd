package com.northwind.hrms.core.utilities.validations;

import com.northwind.hrms.core.utilities.results.ErrorResult;
import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.core.utilities.results.SuccessResult;

public class PasswordValidator {
    public static Result valid(String password, String repeatPassword) {
        if (password.equals(repeatPassword)) {
            return new SuccessResult();
        } else {
            return new ErrorResult("The password entered is not the same..");
        }
    }
}
