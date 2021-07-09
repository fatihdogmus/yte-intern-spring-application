package yte.intern.springapplication.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.springapplication.student.entity.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByStudentNumber(String studentNumber);

    Optional<Student> findByStudentNumber(String studentNumber);
}
