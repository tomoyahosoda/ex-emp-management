package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author 細田智也
 */
public class InsertAdministratorForm {
    /* 名前 */
    @NotBlank(message = "名前の入力は必須です")
    private String name;
    /* メールアドレス */
    @NotBlank(message = "メールアドレスの入力は必須です")
    @Email(message = "メールアドレスの形式が不正です")
    private String mailAddress;
    /* パスワード */
    @NotBlank(message = "パスワードの入力は必須です")
    @Size(min = 1, max = 30, message = "パスワードは1文字以上30文字以内で記載してください")
    private String password;

    @Override
    public String toString() {
        return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
                + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
