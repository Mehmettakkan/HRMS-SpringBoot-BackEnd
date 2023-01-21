package com.northwind.hrms.dataAccess.abstracts;

import com.northwind.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    JobPosition findByJobPosition(String jobPosition);
}
