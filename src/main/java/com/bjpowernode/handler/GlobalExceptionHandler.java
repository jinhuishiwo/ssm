package com.bjpowernode.handler;

import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","消灭美帝暴政,保护我方拉登");
        mv.addObject("ex",ex);
        mv.setViewName("nameError");
        return mv;
    }

    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","大爷你好好休息,干啥费那脑筋");
        mv.addObject("ex",ex);
        mv.setViewName("ageError");
        return mv;
    }

    @ExceptionHandler
    public ModelAndView doOtherException(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","异常警告");
        mv.addObject("ex",ex);
        mv.setViewName("defaultError");
        return mv;
    }
}
