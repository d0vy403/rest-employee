package lt.codeacademy.restemployee.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.restemployee.converter.EmployeeConverter;
import lt.codeacademy.restemployee.dto.CreateEmployeeRequest;
import lt.codeacademy.restemployee.dto.GetEmployeeResponse;
import lt.codeacademy.restemployee.dto.UpdateEmployeeRequest;
import lt.codeacademy.restemployee.entity.Employee;
import lt.codeacademy.restemployee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeConverter employeeConverter;
  private final EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<GetEmployeeResponse> addEmployee(
      @RequestBody CreateEmployeeRequest createEmployeeRequest) {
    Employee employee = employeeConverter.dtoToEntity(createEmployeeRequest);
    Employee savedEmployee = employeeService.addEmployee(employee);
    GetEmployeeResponse getEmployeeResponse = employeeConverter.entityToDto(savedEmployee);
    return ResponseEntity.ok(getEmployeeResponse);
  }

  @GetMapping
  public List<Employee> getEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/{id}")
  public GetEmployeeResponse getEmployeeById(@PathVariable Long id) {
    return employeeConverter.entityToDto(employeeService.getEmployeeById(id));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<GetEmployeeResponse> updateEmployee(
          @PathVariable Long id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
    Employee employee = employeeService.updateEmployee(id, updateEmployeeRequest);
    GetEmployeeResponse getEmployeeResponse = employeeConverter.entityToDto(employee);
    return ResponseEntity.ok(getEmployeeResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
