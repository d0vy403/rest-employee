package lt.codeacademy.restemployee;

import lt.codeacademy.restemployee.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestEmployeeApplication {

  private final EmployeeService employeeService;

  public RestEmployeeApplication(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  public static void main(String[] args) {
    SpringApplication.run(RestEmployeeApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void insertData() {
    employeeService.addTestEmployees();
    System.out.println(employeeService.getAllEmployees());
  }
}
