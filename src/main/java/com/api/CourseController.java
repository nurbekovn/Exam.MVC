package com.api;
import com.model.Course;
import com.service.CompanyService;
import com.service.CourseService;
import com.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final InstructorService instructorService;
    private final CompanyService companyService;

    @Autowired
    public CourseController(CourseService courseService, CompanyService companyService,
                            InstructorService instructorService) {
        this.courseService = courseService;
        this.companyService = companyService;
        this.instructorService = instructorService;
    }


    @GetMapping("/courses/{id}")
    private String getAllCourses(@PathVariable Long id, Model model) {
        model.addAttribute("courses", courseService.getAllCourses(id));
        model.addAttribute("companyId",id);
        model.addAttribute("instructors",instructorService.getInstructorsByCourseId(id));
        System.out.println("all courses done");
        return "course/courses";
    }


    @GetMapping("/{id}/addCourse")
    private String addCourse(@PathVariable Long id, Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("companyId", id);
        return "course/addCourse";
    }


    @PostMapping("/{id}/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course,
                             @PathVariable Long id) {
        courseService.saveCourse(course, id);
        System.out.println(course);
        return "redirect:/courses/courses/"+id;
    }


    @GetMapping("/edit/{id}")
    private String updateCourse(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        model.addAttribute("companyId",course.getCompany().getId());
        return "/course/updateCourse";
    }

    @PostMapping("{id}/{courseId}/update")
    private String saveUpdateCourse(@PathVariable("courseId")Long courseId,
                                    @PathVariable("id")Long id,
                                    @ModelAttribute("course") Course course) {
        courseService.updateCourse(courseId,course);
        return "redirect:/courses/courses/"+id;
    }


    @PostMapping("/{id}/{compId}")
    private String deleteCourse(@PathVariable("id") Long id,
                                @PathVariable("compId") Long compId) {
        courseService.deleteCourse(id);
        return "redirect:/courses/courses/"+compId;
    }
}
