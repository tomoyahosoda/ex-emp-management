package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
    private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = new BeanPropertyRowMapper<>(Employee.class);

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
        try {
            return template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 従業員情報を変更.
     * @param employee 従業員情報
     */
    public void update(Employee employee) {
        String sql = "UPDATE employees SET name = :name, image = :image, gender = :gender, hire_date = :hireDate, zip_code = :zipCode, address = :address, mail_address = :mailAddress, telephone = :telephone, salary = :salary, characteristics = :characteristics, dependents_count = :dependentsCount WHERE id = :id";
        SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
        template.update(sql, param);
    }

}
