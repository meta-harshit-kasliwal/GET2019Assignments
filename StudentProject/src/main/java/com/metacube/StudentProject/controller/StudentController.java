package com.metacube.StudentProject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metacube.StudentProject.services.Student;

@Controller
public class StudentController {
	
	@RequestMapping("/home")                                                
	public String home(HttpServletRequest request){	
		HttpSession session = request.getSession();
		if(session.getAttribute("list")==null){
			session.setAttribute("list", new ArrayList<Student>());
		}
		return "home";
	}
	
	@RequestMapping("/addstudent")
	public String addStudentPage(Model model)
	{ 
		Student student = new Student();
		model.addAttribute("student",student);
		return "add-student-form";
	}
	
	@RequestMapping("/addstudentdetail" )
	public String addStudentDetail(@Valid @ModelAttribute("student") Student student,BindingResult result,Model model,HttpServletRequest request){
		if (result.hasErrors()) {
			System.out.println("in error block");
	        return "add-student-form";
	    }
		
		HttpSession session = request.getSession();
		ArrayList<Student> list = (ArrayList<Student>)session.getAttribute("list");
		list.add(student);
		session.setAttribute("list", list);
		System.out.println(list);
		model.addAttribute("message", "record inserted sucesfully");
		return addStudentPage(model);
	}
	
	@RequestMapping("/ShowStudent")
	public String ShowStudent(Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		model.addAttribute("student_list",(ArrayList<Student>)session.getAttribute("list"));
		return "show-students";
	}

}
 