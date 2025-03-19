package lt.codeacademy.restemployee.repository;

import lt.codeacademy.restemployee.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {}
