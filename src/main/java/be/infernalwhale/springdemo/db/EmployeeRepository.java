package be.infernalwhale.springdemo.db;

import be.infernalwhale.springdemo.controller.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByNameContaining(String partialName);

    // JPQL <> SQL
    @Query("SELECT AVG(e.manager.salary) FROM Employee e")
    Long calculateAverageSalaryJPQL();

    // SELECT AVG(salary_column) FROM Employee WHERE/GROUP BY
    @Query(value = "SELECT AVG(salary_column) FROM Employee", nativeQuery = true)
    Long calculateAverageSalary();
}
