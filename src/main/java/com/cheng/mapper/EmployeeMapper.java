package com.cheng.mapper;

import com.cheng.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper //mybatis的动态代理 springboot集成
public interface EmployeeMapper {
    Employee getEmployee(Integer id);
    void insertEmp(Employee employee);
}
