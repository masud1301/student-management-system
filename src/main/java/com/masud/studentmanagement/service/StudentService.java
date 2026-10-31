package com.masud.studentmanagement.service;

import com.masud.studentmanagement.entity.Student;
import com.masud.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updated) {
        Student existing = getStudentById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setCourse(updated.getCourse());
        return studentRepository.save(existing);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}