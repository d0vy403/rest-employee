package lt.codeacademy.restemployee;
import lt.codeacademy.restemployee.entity.Department;
import lt.codeacademy.restemployee.entity.Employee;
import lt.codeacademy.restemployee.entity.Project;
import lt.codeacademy.restemployee.repository.DepartmentRepository;
import lt.codeacademy.restemployee.repository.EmployeeRepository;
import lt.codeacademy.restemployee.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class RestEmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestEmployeeApplication.class, args);
    }

  @Bean
  CommandLineRunner runner(
      EmployeeRepository employeeRepo,
      ProjectRepository projectRepo,
      DepartmentRepository departmentRepo) {
    return args -> {
      Department devDept = new Department("Development", "111111");
      Department hrDept = new Department("Human Resources", "222222");

      departmentRepo.saveAll(List.of(devDept, hrDept));

      Project projectA = new Project("Project A");
      Project projectB = new Project("Project B");

      projectRepo.saveAll(List.of(projectA, projectB));

      Employee emp1 = new Employee(
              "EMP001",
              "John",
              "Doe",
              LocalDate.of(1990, 1, 15),
              LocalDate.of(2020, 5, 1),
              "Developer",
              devDept,
              projectA
      );

      Employee emp2 = new Employee(
              "EMP002",
              "Jane",
              "Smith",
              LocalDate.of(1985, 8, 22),
              LocalDate.of(2019, 3, 10),
              "HR Specialist",
              hrDept,
              projectB
      );

      employeeRepo.saveAll(List.of(emp1, emp2));

      System.out.println("=== All Employees ===");
      employeeRepo.findAll().forEach(System.out::println);
    };
  }
}
