package com.northwind.hrms.dataAccess.abstracts;

import com.northwind.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer findByEmail(String email);
}
