package dao;

import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    private DbUtil dbUtil = new DbUtil();
    public void closeCon() {
        dbUtil.closeCon();
    }
    public ResultSet query(String sql) {
        try {
            PreparedStatement pstmt = dbUtil.getConnection().prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean update(String sql) {
        try {
            return dbUtil.getConnection().prepareStatement(sql).executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Connection getConnection() {
        return dbUtil.getConnection();
    }
}
