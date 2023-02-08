package ru.maxima.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.maxima.springmvc.dao.PersonDAO;
import ru.maxima.springmvc.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PersonDAO personDAO;

    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String adminPage (Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("people", personDAO.index());
        return "admin/adminPage";
    }

    @PatchMapping("/add")
    public String madeAdmin(@ModelAttribute("person") Person person) {
        personDAO.makeAdmin(person);
        return "redirect:/people";
    }




}
