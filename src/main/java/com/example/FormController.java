package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FormController {

    @Autowired
    RegisterDao registerDao;

    @RequestMapping("/complex")
    public String showForm(){
        return "complex_form";
    }

    @RequestMapping(path = "/handleform",method = RequestMethod.POST)

    //BindingResult is use to validate from like long variable not contain 456hgfgh like this
    public String handleform(@ModelAttribute ("register") Register register,@ModelAttribute ("address1") Address1 address1 ,BindingResult result){
        if(result.hasErrors())
        {
            return "complex_form";
        }
        System.out.println(register);
        registerDao.addPeople(register);
        return "success";
    }

    @RequestMapping("delete/{id}")
    public RedirectView deletePeople(@PathVariable("id")String id){
        registerDao.deletePeople(Long.parseLong(id));
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("/");
        return  redirectView;
    }
}
