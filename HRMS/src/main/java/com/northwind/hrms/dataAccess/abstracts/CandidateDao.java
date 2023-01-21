package com.northwind.hrms.dataAccess.abstracts;

import com.northwind.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    Candidate findByEmail(String email);
    Candidate findByIdentityNumber(String IdentityNumber);

}
