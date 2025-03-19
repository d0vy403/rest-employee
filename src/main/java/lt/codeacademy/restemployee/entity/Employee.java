package lt.codeacademy.restemployee.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"department", "project"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personalCode;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate worksFrom;
    private String position;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Project project;

    public Employee(String personalCode, String name, String lastName, LocalDate birthDate,
                    LocalDate worksFrom, String position, Department department, Project project) {
        this.personalCode = personalCode;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.worksFrom = worksFrom;
        this.position = position;
        this.department = department;
        this.project = project;
    }
}
