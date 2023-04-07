package com.example.demo.formtags;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        // create student object
        Student theStudent = new Student();

        // add student object as a model attribute
        model.addAttribute("student", theStudent);
        model.addAttribute("firstName", theStudent.getFirstName());
        model.addAttribute("lastName", theStudent.getLastName());

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("country") String country,
                              @RequestParam("language") String language,
                              @PathParam("os1") String os1,
                              @PathParam("os2") String os2,
                              @PathParam("os3") String os3) {

        return "student-confirmation";
    }

}
