package com.api;

import com.model.Instructor;
import com.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping("/{id}/new")
    public String newIns(@PathVariable Long id, Model model) {
        model.addAttribute("newInstructor", new Instructor());
        model.addAttribute("comId",id);
        return "instructors/addIns";

    }


    @PostMapping("/{id}/save")
    public String saveIns(@ModelAttribute("newInstructor") Instructor instructor,
                          @PathVariable Long id) {
        instructorService.saveInstructor(id, instructor);
        return "redirect:/courses/courses/"+id;
    }

    @GetMapping("/{id}/edit")
    public String editIns(@PathVariable("id") Long id, Model model) {
        Instructor instructor = instructorService.getInstructorById(id);
        model.addAttribute("ins", instructor);
        model.addAttribute("comId", instructor.getCompany().getId());
        return "instructors/updateIns";
    }

    @PostMapping("/{id}/{comId}/update")
    public String updateIns(@ModelAttribute("instructor") Instructor instructor
            , @PathVariable Long id, @PathVariable Long comId) {
        instructorService.updateInstructor(id, instructor);
        System.out.println("*****************");
        return "redirect:/instructors/courses/" + comId;

    }
}
