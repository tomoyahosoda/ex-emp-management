package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;

/**
 * 従業員サービス.
 * @author 細田智也
 */
@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 従業員情報を全件取得.
     * @return 従業員リスト
     */
    public List<Employee> showList() {
        return employeeRepository.findAll();
    }

    /**
     * 従業員情報を取得.
     * @param id ID
     * @return 従業員情報
     */
    public Employee showDetail(Integer id) {
        return employeeRepository.load(id);
    }

    /**
     * 従業員情報を更新.
     * @param employee 従業員情報
     */
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }
}
