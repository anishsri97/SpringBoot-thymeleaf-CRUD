package com.myApp.myApplication.restController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.myApplication.Service.employeeService;
import com.myApp.myApplication.entity.employee;

@Controller
@RequestMapping("/api")
public class restController 
{
   private employeeService empService;
   
  
   // injection of constructor
   @Autowired
   restController(employeeService emp)
   {
	   this.empService=emp;
   }
   //List<employee> em =null;
   // get result
   @GetMapping("/hello")
   public String  hellou(Model model)
   {
	  model.addAttribute("thedate", new java.util.Date());
	   return "hello"; 
   }
   
   @GetMapping("/employees")
   public String getdata(Model model)
   {
	   List<employee> list = empService.employeeList();
	   
	   model.addAttribute("employees", list);
	   
	   return "res/list";
   }
   
   @GetMapping("/showForm")
   
   public String add(Model model)
   {
	   employee emp = new employee();
	   
	   model.addAttribute("employees",emp);
	   
	   return "res/form";
   }
   
   
   @PostMapping("/save")
   
   public String save(@ModelAttribute("employees") employee employees)
   {
	// save the employee
			empService.save(employees);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/api/employees";
   }
   
   @GetMapping("/employee/{id}")
   public employee getByid(@PathVariable int id)
   {
	   employee e =  empService.getById(id);
	   if(e==null) throw new RuntimeException("not found"+id);
	   return e;
   }
   
   
   @GetMapping("/detail/{id}")
   
   public String detail(@PathVariable int id,Model model)
   {
	         employee emp = empService.getById(id);
	         
	         model.addAttribute("emp", emp);
	         
	         return "edetail";
	         
	         
	         
   }
   @PostMapping("/employeeAdd")
   public employee add(@RequestBody employee emp)
   {
	   emp.setId(0);  
	   empService.add(emp);
	   return emp;
   }
   
   @PutMapping("/update")
   public employee update(@RequestBody employee emp)
   {
	    employee e=empService.add(emp);
	    return e;
   }
   
   
   @GetMapping("/updt")
   
   public String updateInfo(@RequestParam("id") int id, Model model)
   {
	   employee emp = empService.getById(id);
	   
	   model.addAttribute("employees", emp);
	   
	   return "res/form";
   }
   
   
   @DeleteMapping("delete/{id}")
   public employee deleteEmp(@PathVariable int id)
   {
	   employee e = empService.getById(id);
	   if(e==null) throw new RuntimeException("id not found in database"+id);
	   empService.deleteByid(id);
	   return e;
   }
   
   
  @GetMapping("/del")
  
  public String delete(@RequestParam("id") int id)
  {
	  empService.deleteByid(id);
	  
	  return "redirect:/api/employees";
	  
  }
   
}
