package com.northwind.hrms.core.utilities.adapters.concretes;

import com.northwind.hrms.core.utilities.adapters.abstracts.PersonCheckService;
import com.northwind.hrms.core.utilities.results.ErrorResult;
import com.northwind.hrms.core.utilities.results.Result;
import com.northwind.hrms.core.utilities.results.SuccessResult;
import com.northwind.hrms.entities.concretes.Candidate;
import com.northwind.hrms.mernis.BWNKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements PersonCheckService {
    @Override
    public Result checkIfRealPerson(Candidate candidate) throws Exception {
        BWNKPSPublicSoap publicSoap = new BWNKPSPublicSoap();

        boolean result = publicSoap.TCKimlikNoDogrula(Long.valueOf(candidate.getIdentityNumber()),
                candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
                candidate.getBirthYear());

        if (!result) {
            return new ErrorResult();
        } else {
            return new SuccessResult();
        }
    }
}
