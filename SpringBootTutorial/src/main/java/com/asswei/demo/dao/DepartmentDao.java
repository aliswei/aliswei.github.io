package com.asswei.demo.dao;

import com.asswei.demo.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department>departments=null;
    @Autowired
    @Lazy
    private DepartmentDao departmentDao;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101, new Department(101,"教学部"));
        departments.put(102, new Department(102,"运动部"));
        departments.put(103, new Department(103,"招商部"));
    }
    //获取所有的部门信息
    public Collection<Department> getDepartment(){
        return departments.values();
    }
    //通过id得到部门
    public Department getDepartById(Integer id){
        return departments.get(id);
    }
}
