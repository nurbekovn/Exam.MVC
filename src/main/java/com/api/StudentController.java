package com.api;
import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}")
    private String getAllStudents(@PathVariable Long id, Model model) {
        model.addAttribute("students",studentService.getStudents(id));
        model.addAttribute("courseId",id);
        return "student/students";
    }


    @GetMapping("/{id}/addStudent")
    private String addStudent(@PathVariable Long id , Model model) {
        model.addAttribute("student",new Student());
        model.addAttribute("courseId",id);
        return "student/addStudent";
    }

    @PostMapping("/{id}/saveStudent")
    private String saveStudent(@ModelAttribute("student") Student student, @PathVariable Long id) {
        studentService.saveStudent(student,id);
        return "redirect:/students/students/" +id;

    }


    @GetMapping("/edit/{id}")
    private String updateStudent(@PathVariable("id") Long id , Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "student/updateStudent";
    }



    @PostMapping("/{id}/{courseId}")
    private String deleteStudent(@PathVariable("id") Long id ,
                                 @PathVariable("courseId") Long courseId) {
        studentService.deleteStudent(id);
        return "redirect:/students/students/" + courseId;
    }

}
