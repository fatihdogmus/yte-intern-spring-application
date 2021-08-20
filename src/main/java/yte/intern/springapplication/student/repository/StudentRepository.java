package yte.intern.springapplication.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springapplication.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
