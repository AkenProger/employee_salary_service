package com.megacom.crud_service.dao;

import com.megacom.crud_service.models.dto.SalariesDto;
import com.megacom.crud_service.models.entities.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalariesRepository extends JpaRepository<Salaries, Long> {
    @Query(value = "SELECT * FROM salaries s where s.salary < ?1", nativeQuery = true)
    List<Salaries> findByWhereSalaryMin(double sum);

}
