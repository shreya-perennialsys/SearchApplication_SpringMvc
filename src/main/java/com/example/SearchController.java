package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/search")
    public RedirectView search(@RequestParam("querybox") String query){

        String url="https://www.google.com/search?q="+query;
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
    }

    @RequestMapping("/user/{userId}/{userName}")
    public String getUserDetails(@PathVariable("userId") int userId,@PathVariable("userName") String userName)
    {
        System.out.println("userId="+userId);
        System.out.println("userName="+userName);

        //Insert number format exception
        Integer.parseInt(userName);

        return "home";
    }
    //Exception handling at processing request area
    /*@RequestMapping("/excep")
    public String excp(){
        String str=null;
        System.out.println(str.length());
        return "home";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            NullPointerException.class
    })
    public String exceptionHandlerNull(){
        return "null_page";
    }

    @ExceptionHandler({
            NumberFormatException.class
    })
    public String exceptionHandlerNumberFormat(){
        return "number_format_Exception";
    }

    //all types of exception handle by this Exception.class
    @ExceptionHandler({Exception.class})
    public String allException(){
        return "All_Exception";
    }*/
}
