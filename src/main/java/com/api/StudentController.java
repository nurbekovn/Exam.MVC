package com.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.model.Student;
import com.service.StudentService;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public String getAllStudents(@PathVariable Long id, Model model, @ModelAttribute("student") Student student) {
        model.addAttribute("students", studentService.countOfStudents(id));
        model.addAttribute("courseId", id);
        return "/students";
    }

    @GetMapping("/{id}/addStudent")
    public String addStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courseId", id);
        return "/addStudent";
    }

    @PostMapping("/{id}/save")
    public String saveStudent(@PathVariable Long id, @ModelAttribute("student") @Valid Student student,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/addStudent";
        }
        studentService.saveStudent(student, id);
        return "redirect:/students/" + id;
    }

    @GetMapping("/{courseId}/{studentId}/edit")
    public String updateStudent(@PathVariable Long courseId, @PathVariable Long studentId, Model model) {
        model.addAttribute("student", studentService.getStudentById(studentId));
        model.addAttribute("courseId", courseId);
        return "/updateStudent";
    }

    @PostMapping("/{id}/{studentId}/update")
    public String saveUpdateStudent(@PathVariable Long id, @PathVariable Long studentId,
                                    @ModelAttribute("student") @Valid Student student,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/updateStudent";
        }
        studentService.updateStudent(studentId, student);
        return "redirect:/students/" + id;
    }

    @PostMapping("/{courseId}/{studentId}/delete")
    public String deleteStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students/" + courseId;
    }

    @PostMapping("/{courseId}/{studentId}/assign")
    public String assignStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        studentService.assignStudentToCourse(courseId, studentId);
        return "redirect:/students/" + courseId;
    }
}
