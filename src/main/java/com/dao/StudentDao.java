package com.dao;

import com.domian.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentDao extends JpaRepository<Student, Integer> , JpaSpecificationExecutor<Student> {
}
