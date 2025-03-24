package lt.codeacademy.restemployee.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateEmployeeRequest {
  private String name;
  private String lastName;
  private Date worksFrom;
  private String position;
  private String departmentTitle;
  private String projectTitle;
}
