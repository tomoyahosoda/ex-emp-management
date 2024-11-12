package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Administrator;


/**
 * 管理者リポジトリ.
 * @author 細田智也
 */
@Repository
public class AdministratorRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mail_address"));
        administrator.setPassword(rs.getString("password"));
        return administrator;
    };

    /**
     * 管理者情報をインサートする.
     * @param administrator 管理者情報
     */
    public void insert(Administrator administrator) {
        String sql = "INSERT INTO administrators(name, mail_address, password) VALUES(:name, :mailAddress, :password)";
        SqlParameterSource param = new MapSqlParameterSource().addValue("name", administrator.getName()).addValue("mailAddress", administrator.getMailAddress()).addValue("password", administrator.getPassword());
        template.update(sql, param);
    }

    /**
     * メールアドレスとパスワードから管理者を探す.
     * @param mailAddress メールアドレス
     * @param password パスワード
     * @return 管理者情報
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
        String sql = "SELECT id, name, mail_address, password FROM administrators WHERE mail_address = :mailAddress AND password = :password;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
        List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
        if (administratorList.size() == 0) {
            return null;
        }
        return administratorList.get(0);
    }
}
