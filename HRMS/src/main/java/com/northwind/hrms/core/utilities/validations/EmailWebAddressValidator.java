package com.northwind.hrms.core.utilities.validations;

import com.northwind.hrms.core.utilities.results.ErrorResult;
import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.core.utilities.results.SuccessResult;

public class EmailWebAddressValidator {
    public static Result valid(String email, String webAddress) {
        String[] emailSplit = email.split("@", 2);
        String[] webSplit = webAddress.split("www.", 2);
        //contains belirtilen dizede bir karakter dizisi olup olmadığını gösterir
        if (!(webSplit[1].contains(emailSplit[1]))) {
            return new ErrorResult("Email and web address must have the same domain..");
        } else {
            return new SuccessResult();
        }

    }
}
