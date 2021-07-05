package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.MyUserException;
import com.bjpowernode.exception.NameException;
import com.bjpowernode.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value ="/student")
public class MyController {

    @Resource
    private StudentService studentService;

    @RequestMapping(value ="/addStudent.do")
    public ModelAndView addStudent(Student stu) throws MyUserException {
        System.out.println("helloworld");
        if(stu.getAge()>80){
            throw new AgeException("大爷,您请注意身体");
        }
        if("拉登".equals(stu.getName())){
            throw new NameException("FBI WARNING");
        }

        ModelAndView modelAndView=new ModelAndView();
        int i=studentService.addStudent(stu);
        if(stu!=null&&i>0){
            String s="添加学生:["+stu.getName()+"]成功";
            modelAndView.addObject("s",s);
            modelAndView.setViewName("result");
            return modelAndView;
        }
        modelAndView.addObject("s","添加失败");
        modelAndView.setViewName("result");
        return modelAndView;
    }

    @RequestMapping(value ="/selectStudent.do",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> selectStudent(){
        System.out.println("selectStudent方法执行了");
        List<Student> students=studentService.findStudent();
        return students;
    }
}
