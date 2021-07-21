package com.asswei.demo.controller;

import com.asswei.demo.dao.DepartmentDao;
import com.asswei.demo.dao.EmployeeDao;
import com.asswei.demo.pojo.Department;
import com.asswei.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee>employees = employeeDao.getEmployee();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);

        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String updateEmp(@PathVariable("id")Integer id, Model model ){
        Employee employee = employeeDao.getEmployById(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delete/{id}")
    public String delEmp(@PathVariable("id")int id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
