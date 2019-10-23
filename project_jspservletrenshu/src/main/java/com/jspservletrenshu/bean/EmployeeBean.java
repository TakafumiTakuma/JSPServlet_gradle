package com.jspservletrenshu.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeBean {
    private String id;
    private String name;
    private String age;
    private String tell;
    private String password;

    //データベースから会員情報を一覧表示する際に利用するメソッド
    public EmployeeBean(ResultSet rs){
        try{
            id = rs.getString(1);
            name = rs.getString(2);
            age = rs.getString(3);
            tell = rs.getString(4);
            password = rs.getString(5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(String age){
        this.age = age;
    }
    public String getAge(){
        return age;
    }

    public void setTell(String tell){
        this.tell = tell;
    }
    public String getTell(){
        return tell;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    //会員情報を一覧表示する際、一度に値を登録する時に利用するメソッド
    public EmployeeBean(String id, String name, String age, String tell, String password){
        this.id = id;
        this.name = name;
        this.age = age;
        this.tell = tell;
        this.password = password;
    }

}
