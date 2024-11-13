package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * 従業員更新フォーム.
 * 
 * @author 細田智也
 */
public class UpdateEmployeeForm {
    /* 従業員ID */
    private String id;

    /* 名前 */
    @NotBlank(message = "名前の入力は必須です")
    private String name;

    /* 画像 */
    private String image;

    /* 性別 */
    @NotBlank(message = "性別は必須です")
    private String gender;

    /* 入社日 */
    @NotBlank(message = "日付は必須です")
    private String hireDate;

    /* メールアドレス */
    @NotBlank(message = "メールアドレスの入力は必須です")
    @Email(message = "メールアドレスの形式が不正です")
    private String mailAddress;

    /* 郵便番号 */
    @NotBlank(message = "郵便番号の入力は必須です")
    private String zipCode;

    /* 住所 */
    @NotBlank(message = "住所の入力は必須です")
    private String address;

    /* 電話番号 */
    @NotBlank(message = "電話番号の入力は必須です")
    private String telephone;

    /* 給料 */
    @NotNull(message = "給料の入力は必須です")
    private Integer salary;

    /* 特性 */
    @NotBlank(message = "特性の入力は必須です")
    private String characteristics;

    /* 扶養人数 */
    @NotBlank(message = "扶養人数を入力してください")
    @Pattern(regexp = "[0-9]+", message = "数字を入力してください")
    private String dependentsCount;

    @Override
    public String toString() {
        return "UpdateEmployeeForm [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender
                + ", hireDate=" + hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address="
                + address + ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
                + ", dependentsCount=" + dependentsCount + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDependentsCount() {
        return dependentsCount;
    }

    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

}
