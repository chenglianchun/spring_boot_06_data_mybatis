package com.cheng.controller;

import com.cheng.bean.Employee;
import com.cheng.mapper.DepartmentMapper;
import com.cheng.bean.Department;
import com.cheng.mapper.EmployeeMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DeptController {

    @Resource
    public DepartmentMapper departmentMapper;

    @Resource
    public EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable Integer id){
        return departmentMapper.getDeptById(id);
    }


    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployeeMapper(@PathVariable Integer id) {
        return employeeMapper.getEmployee(id);
    }


    @GetMapping("/emp")
    public Employee insertEmployeeMapper(Employee employee){
        employeeMapper.insertEmp(employee);
        return employee;
    }
}
