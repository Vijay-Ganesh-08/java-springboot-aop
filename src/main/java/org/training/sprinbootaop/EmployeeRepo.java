package org.training.sprinbootaop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstnameOrderByEid(String firstName);

    @Query("from Employee where lastname = :lastName")
    List<Employee> find(@Param ("lastName") String lastName);

}