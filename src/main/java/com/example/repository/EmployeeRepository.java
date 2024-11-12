package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Employee;

/**
 * 従業員リポジトリ.
 * @author 細田智也
 */
@Repository
public class EmployeeRepository {
    private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setImage(rs.getString("image"));
        employee.setGender(rs.getString("gender"));
        employee.setHireDate(rs.getDate("hire_date"));
        employee.setMailAddress(rs.getString("mail_address"));
        employee.setZipCode(rs.getString("zip_code"));
        employee.setAddress(rs.getString("address"));
        employee.setTelephone(rs.getString("telephone"));
        employee.setSalary(rs.getInt("salary"));
        employee.setCharacteristics(rs.getString("characteristics"));
        employee.setDependentsCount(rs.getInt("dependents_count"));
        return employee;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 従業員一覧を入社日順で取得.
     * @return 従業員一覧
     */
    public List<Employee> findAll() {
        String sql = "SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count FROM employees ORDER BY hire_date DESC;";
        return template.query(sql, EMPLOYEE_ROW_MAPPER);
    }

    /**
     * 主キーから従業員情報を取得.
     * @param id ID
     * @return 従業員情報
     */
    public Employee load(Integer id) {
        String sql = "SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count FROM employees WHERE id = :id;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        return template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
    }

    /**
     * 従業員情報を変更.
     * @param employee 従業員情報
     */
    public void update(Employee employee) {
        String sql = "UPDATE employees SET name = :name, image = :image, gender = :gender, hire_date = :hireDate, mail_address = :mailAddress, zip_code = :zipCode, address = :address, telephone = :telephone, salary = :salary, characteristics = :characteristics, dependents_count = :dependentsCount;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("name", employee.getName()).addValue("image", employee.getImage()).addValue("gender", employee.getGender()).addValue("hireDate", employee.getHireDate()).addValue("mailAddress", employee.getMailAddress()).addValue("zipCode", employee.getZipCode()).addValue("address", employee.getAddress()).addValue("telephone", employee.getTelephone()).addValue("salary", employee.getSalary()).addValue("characteristics", employee.getCharacteristics()).addValue("dependentsCount", employee.getDependentsCount());
        template.update(sql, param);
    }

}
