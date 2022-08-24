package com.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LessonController {

    @GetMapping("{/id}/addLesson")
    private String addLesson(@PathVariable Long id , Model model) {
        return "lesson/addLesson";
    }

}
