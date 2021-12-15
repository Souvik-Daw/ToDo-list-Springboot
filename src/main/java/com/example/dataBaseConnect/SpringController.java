package com.example.dataBaseConnect;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;

@Controller
public class SpringController {
	
	@Autowired
	studentRepo repo;
	
	int id=0;
	
	
	
	@RequestMapping("/addStudent")
	public String addStudent(student s, HttpServletResponse httpResponse) throws IOException
	{
		repo.save(s);
		httpResponse.sendRedirect("/home");
        return null;
	}
	
	@RequestMapping("/update")
	public ModelAndView updatePage(@RequestParam(name = "id") int id)
	{
		this.id=id;
		System.out.println(id+"");
		ModelAndView mv=new ModelAndView("update.jsp");
		return mv;
	}
	
	
	@RequestMapping("/updateData")
	public String update(@RequestParam(name = "name") String name, HttpServletResponse httpResponse) throws IOException
	{
		student s=new student();
		s.setId(id);
		s.setName(name);
		repo.save(s);
		httpResponse.sendRedirect("/home");
        return null;
	}
	
	@RequestMapping("/getStudent")
	public ModelAndView getStudent(@RequestParam("id") Integer id)
	{
		ModelAndView mv=new ModelAndView("showData.jsp");
		student p=new student();
		p.setId(5);;
		p.setName("afdfd");
		student s=repo.findById(id).orElse(p);
		mv.addObject("s",s);
		return mv;	
	}
	
	@RequestMapping("/home")
	public ModelAndView student()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject("students",  repo.findAll());
		return mv;
		
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String id(@PathVariable("id") int id,HttpServletResponse httpResponse) throws IOException
	{
		repo.deleteById(id);
		httpResponse.sendRedirect("/home");
		return null;
		
	}
}
