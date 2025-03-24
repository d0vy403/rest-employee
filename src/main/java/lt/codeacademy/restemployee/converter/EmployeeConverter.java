package lt.codeacademy.restemployee.converter;

import lt.codeacademy.restemployee.dto.CreateEmployeeRequest;
import lt.codeacademy.restemployee.dto.GetEmployeeResponse;
import lt.codeacademy.restemployee.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public GetEmployeeResponse entityToDto(Employee employee) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setId(employee.getId());
        response.setPersonalCode(employee.getPersonalCode());
        response.setName(employee.getName());
        response.setLastName(employee.getLastName());
        response.setBirthDate(employee.getBirthDate());
        response.setWorksFrom(employee.getWorksFrom());
        response.setPosition(employee.getPosition());
        return response;
    }

    public Employee dtoToEntity(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = new Employee();
        employee.setPersonalCode(createEmployeeRequest.getPersonalCode());
        employee.setName(createEmployeeRequest.getName());
        employee.setLastName(createEmployeeRequest.getLastName());
        employee.setBirthDate(createEmployeeRequest.getBirthDate());
        employee.setWorksFrom(createEmployeeRequest.getWorksFrom());
        employee.setPosition(createEmployeeRequest.getPosition());
        return employee;

    }
}
