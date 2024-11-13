package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

/**
 * 従業員情報を操作するコントローラー.
 * @author 細田智也
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    HttpSession session;

    /**
     * 従業員一覧を表示.
     * @param model requestスコープ
     * @return 従業員一覧へフォワード
     */
    @GetMapping("/showList")
    public String showList(Model model) {
        List<Employee> employeeList = employeeService.showList();
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }

    /**
     * 従業員詳細を表示.
     * @param id ID
     * @param model requestスコープ
     * @param form フォーム
     * @return 従業員詳細へフォワード
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form) {
        if (session.getAttribute("administratorName") == null) {
            model.addAttribute("message", "ログインが必要です");
            return showList(model);
        }
        Employee employee = employeeService.showDetail(Integer.parseInt(id));
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    /**
     * 従業員情報を更新.
     * @param form フォーム
     * @return 従業員一覧へリダイレクト
     */
    @PostMapping("/update")
    public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return showDetail(form.getId(), model, form);
        }
        Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
        employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
        employeeService.update(employee);
        return "redirect:/employee/showList";
    }
}
