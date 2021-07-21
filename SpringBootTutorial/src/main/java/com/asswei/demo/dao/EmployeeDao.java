package com.asswei.demo.dao;

import com.asswei.demo.pojo.Department;
import com.asswei.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    //模拟数据库数据
    private static Map<Integer, Employee> employees=null;
    @Autowired
    @Lazy
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(101, new Employee(101,"A","345@qq.com",1,new Department(101,"教学部")));
        employees.put(102, new Employee(102,"B","345@qq.com",1,new Department(102,"运动部")));
        employees.put(103, new Employee(103,"C","345@qq.com",1,new Department(103,"招商部")));
    }
    private static Integer initId = 104;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

    //获取所有的部门信息
    public Collection<Employee> getEmployee(){
        return employees.values();
    }
    //通过id得到部门
    public Employee getEmployById(Integer id){
        return employees.get(id);
    }
}
