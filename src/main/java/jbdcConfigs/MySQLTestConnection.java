package jbdcConfigs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {
    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        return MySQLConnUtils.getMySQLConnection();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Get connection... ");

        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = MySQLTestConnection.getMyConnection();

        System.out.println("Opened connection: " + conn);

        Statement statement = conn.createStatement();

        String sql = "SELECT emp.employee_id, emp.emp_firstname, emp.emp_middle_name, emp.emp_lastname \n" +
                "FROM `hs_hr_employee` as emp\n" +
                "ORDER BY emp.employee_id DESC;";

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt trên kết quả trả về
        while (rs.next()) {
            // Di chuyển con trỏ xuống bản ghi kế tiếp.
            int empId = rs.getInt(1);
            String empFirstName = rs.getString(2);
            String empMiddleName = rs.getString(3);
            String empLastName = rs.getString("emp_lastname");

            System.out.println("--------------------");
            System.out.println("Emp Id: " + empId);
            System.out.println("Emp First Name: " + empFirstName);
            System.out.println("Emp Middle Name: " + empMiddleName);
            System.out.println("Emp Last Name: " + empLastName);
        }
        // Đóng kết nối
        conn.close();
        System.out.println("---------- Closed connection ----------");
    }
}
