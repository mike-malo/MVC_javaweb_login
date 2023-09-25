package dao;

import model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends BaseDao {
    public Admin login(String name, String password) {
        String sql = "select * from users where username = '" + name + "' and password = '" + password + "'";
        ResultSet ret = query(sql);
        try {
            if (ret.next()) {
                Admin admin = new Admin();
                admin.setId(ret.getInt("id"));
                admin.setName(ret.getString("username"));
                admin.setPassword(ret.getString("password"));
                admin.setStatus(ret.getInt("status"));
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
