/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.sql.Connection;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Kim Khang
 */
public class Users extends DBContext {
    private String account, password, name, gender, address, dob;

    public Users() {
        connect();
    }

    public Users(String account, String password) {
        this.account = account;
        this.password = password;
        connect();
    }

    public Users(String account, String password, String name, String gender, String address, String dob) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    // khai báo các thành phần xử lý db
    Connection cnm;//ket noi sql
    //Statement stm;//thuc hien cau lenh sql;
    ResultSet rs;//luu tru va xu ly du lieu;
    PreparedStatement stm;

    private void connect() {
        cnm = connection;
        if (cnm != null) {
            System.out.println("connnect success");

        } else {
            System.out.println("connect fail");
        }

    }

    public String getNameByAccount() {
        try {
            String sql = "select * from Users where account =?";
            stm = cnm.prepareStatement(sql);
            stm.setString(1, account);
            rs = stm.executeQuery();
            while (rs.next()) {
                String name = rs.getString(3);
                return name;
            }
        } catch (Exception e) {
            System.out.println("getNameByAccount" + e.getMessage());
        }
        return "";
    }
    public ArrayList<Users> getListUser(){
        ArrayList<Users> data=new ArrayList<Users>();
        try {
            String sql = "select * from Users";
            stm = cnm.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String account =rs.getString(1);
                String password=rs.getString(2);
                String name=rs.getString(3);
                String gender=String.valueOf(rs.getBoolean(4));
                String address=rs.getString(5);
                String dob = String.valueOf(rs.getDate(6));
                Users u = new Users(account, password, name, gender, address, dob);
                data.add(u);    
                
            }
        } catch (Exception e) {
            System.out.println("getListUser" + e.getMessage());

        }
        return data;
    }
}
