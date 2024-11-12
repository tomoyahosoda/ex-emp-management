package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.service.AdministratorService;

/**
 * 管理者登録画面表示を処理するコントローラー
 * @author 細田智也
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    /**
     * 管理者情報を挿入する.
     * @param form フォーム
     * @return 挿入画面へフォワード
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        administrator.setName(form.getName());
        administrator.setMailAddress(form.getMailAddress());
        administrator.setPassword(form.getPassword());
        return "administrator/insert";
    }
}
