package lt.codeacademy.restemployee.entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String personalCode;
  private String name;
  private String lastName;
  private Date birthDate;
  private Date worksFrom;
  private String position;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Department department;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Project project;
}
