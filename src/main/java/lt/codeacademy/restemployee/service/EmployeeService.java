package lt.codeacademy.restemployee.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.restemployee.dto.UpdateEmployeeRequest;
import lt.codeacademy.restemployee.entity.Department;
import lt.codeacademy.restemployee.entity.Employee;
import lt.codeacademy.restemployee.entity.Project;
import lt.codeacademy.restemployee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepo;
  private final EmployeeRepository employeeRepository;

  public List<Employee> getAllEmployees() {
    return employeeRepo.findAll();
  }

  public Employee addEmployee(Employee employee) {
    return employeeRepo.saveAndFlush(employee);
  }

  public Employee getEmployeeById(Long id) {
    return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
  }

  public Employee updateEmployee(Long id, UpdateEmployeeRequest updateEmployeeRequest) {
    Employee existingEmployee =
            employeeRepo
                    .findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

    if (updateEmployeeRequest.getName() != null) {
      existingEmployee.setName(updateEmployeeRequest.getName());
    }
    if(updateEmployeeRequest.getLastName() != null) {
      existingEmployee.setLastName(updateEmployeeRequest.getLastName());
    }
    if(updateEmployeeRequest.getWorksFrom() != null) {
      existingEmployee.setWorksFrom(updateEmployeeRequest.getWorksFrom());
    }
    if (updateEmployeeRequest.getPosition() != null) {
      existingEmployee.setPosition(updateEmployeeRequest.getPosition());
    }
    return employeeRepo.saveAndFlush(existingEmployee);
  }

  public void deleteEmployee(Long id) {
    if (employeeRepo.existsById(id)) {
      employeeRepo.deleteById(id);
    } else {
      throw new RuntimeException("Employee not found");
    }
  }

  public void addTestEmployees() {
    List<Employee> employees = new ArrayList<>();

    Employee employee1 = new Employee();
    employee1.setPersonalCode("12345");
    employee1.setName("John");
    employee1.setLastName("Doe");
    employee1.setBirthDate(Date.valueOf("1991-04-03"));
    employee1.setWorksFrom(Date.valueOf("2022-05-06"));
    employee1.setPosition("Software Engineer");

    Department department1 = new Department();
    department1.setTitle("Department 1");
    department1.setManagerPersonalCode(employee1.getPersonalCode());

    Project project1 = new Project();
    project1.setTitle("Project Alpha");

    employee1.setProject(project1);
    employee1.setDepartment(department1);
    employees.add(employee1);

    Employee employee2 = new Employee();
    employee2.setPersonalCode("67890");
    employee2.setName("Jane");
    employee2.setLastName("Smith");
    employee2.setBirthDate(Date.valueOf("1985-08-15"));
    employee2.setWorksFrom(Date.valueOf("2023-01-10"));
    employee2.setPosition("Data Analyst");

    Department department2 = new Department();
    department2.setTitle("Department 2");
    department2.setManagerPersonalCode(employee2.getPersonalCode());

    Project project2 = new Project();
    project2.setTitle("Project Beta");

    employee2.setProject(project2);
    employee2.setDepartment(department2);
    employees.add(employee2);

    Employee employee3 = new Employee();
    employee3.setPersonalCode("13579");
    employee3.setName("David");
    employee3.setLastName("Lee");
    employee3.setBirthDate(Date.valueOf("1998-12-20"));
    employee3.setWorksFrom(Date.valueOf("2023-03-22"));
    employee3.setPosition("Frontend Developer");

    employee3.setProject(project1);
    employee3.setDepartment(department1);
    employees.add(employee3);

    Employee employee4 = new Employee();
    employee4.setPersonalCode("24680");
    employee4.setName("Sarah");
    employee4.setLastName("Jones");
    employee4.setBirthDate(Date.valueOf("1979-06-01"));
    employee4.setWorksFrom(Date.valueOf("2022-11-15"));
    employee4.setPosition("Backend Developer");
    employee4.setProject(project2);
    employee4.setDepartment(department2);
    employees.add(employee4);

    Employee employee5 = new Employee();
    employee5.setPersonalCode("11223");
    employee5.setName("Michael");
    employee5.setLastName("Brown");
    employee5.setBirthDate(Date.valueOf("1993-02-28"));
    employee5.setWorksFrom(Date.valueOf("2023-06-08"));
    employee5.setPosition("QA Engineer");
    employee5.setProject(project1);
    employee5.setDepartment(department1);
    employees.add(employee5);

    Employee employee6 = new Employee();
    employee6.setPersonalCode("44556");
    employee6.setName("Emily");
    employee6.setLastName("Davis");
    employee6.setBirthDate(Date.valueOf("1988-09-10"));
    employee6.setWorksFrom(Date.valueOf("2022-09-20"));
    employee6.setPosition("UI/UX Designer");
    employee6.setProject(project2);
    employee6.setDepartment(department2);
    employees.add(employee6);

    Employee employee7 = new Employee();
    employee7.setPersonalCode("77889");
    employee7.setName("Robert");
    employee7.setLastName("Wilson");
    employee7.setBirthDate(Date.valueOf("1995-05-05"));
    employee7.setWorksFrom(Date.valueOf("2023-08-01"));
    employee7.setPosition("Project Manager");
    employee7.setProject(project1);
    employee7.setDepartment(department1);
    employees.add(employee7);

    Employee employee8 = new Employee();
    employee8.setPersonalCode("90123");
    employee8.setName("Jessica");
    employee8.setLastName("Garcia");
    employee8.setBirthDate(Date.valueOf("1982-11-22"));
    employee8.setWorksFrom(Date.valueOf("2022-12-12"));
    employee8.setPosition("System Administrator");
    employee8.setProject(project2);
    employee8.setDepartment(department2);
    employees.add(employee8);

    Employee employee9 = new Employee();
    employee9.setPersonalCode("34567");
    employee9.setName("William");
    employee9.setLastName("Rodriguez");
    employee9.setBirthDate(Date.valueOf("1990-07-18"));
    employee9.setWorksFrom(Date.valueOf("2023-10-15"));
    employee9.setPosition("DevOps Engineer");
    employee9.setProject(project1);
    employee9.setDepartment(department1);
    employees.add(employee9);

    Employee employee10 = new Employee();
    employee10.setPersonalCode("89012");
    employee10.setName("Ashley");
    employee10.setLastName("Martinez");
    employee10.setBirthDate(Date.valueOf("1987-03-30"));
    employee10.setWorksFrom(Date.valueOf("2022-07-01"));
    employee10.setPosition("Security Engineer");
    employee10.setProject(project2);
    employee10.setDepartment(department2);
    employees.add(employee10);

    employeeRepository.saveAllAndFlush(employees);
  }
}
