package lt.codeacademy.restemployee.repository;


import lt.codeacademy.restemployee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {}
