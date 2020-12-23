package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
    @RequestMapping("/excep")
    public String excp(){
//        String str=null;
//        System.out.println(str.length());
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
//    @ExceptionHandler({Exception.class})
//    public String allException(){
//        return "All_Exception";
//    }
}
