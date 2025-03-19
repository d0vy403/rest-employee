package lt.codeacademy.restemployee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department {
  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private String managerPersonalCode;

  public Department(String title, String managerPersonalCode) {
    this.title = title;
    this.managerPersonalCode = managerPersonalCode;
  }
}
