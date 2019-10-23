package com.jspservletrenshu.bean;

public class EmployeeInsertBean {
    private String name;
    private String age;
    private String tell;
    private String password;

    public EmployeeInsertBean(String name,String age, String tell, String password){
        this.name = name;
        this.name = age;
        this.name = tell;
        this.name = password;
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

}
