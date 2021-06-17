package com.unityliu.pojo;

import java.util.HashMap;
import java.util.Map;

//        key:warehouse_id
//        key:employee_name
//        key:employee_gander
//        key:employee_born_date
//        key:employee_position
//        key:employee_account
//        key:vercode
//        key:employee_password
//        key:employee_password_repeat

public class UserIdentity {
    private String warehouseId; //仓库编号
    private String employeeName;//姓名
    private String employeeGender;     //性别
    private String employeeBornDate;    //出生日期
    private String employeeAccount;   //邮箱
    private String employeePassword;   //密码
    private String employeePosition;//职位
    private int employeeSalary;

    public HashMap getParamsByName(){
        HashMap map = new HashMap();
        map.put("warehouse_id",warehouseId);
        map.put("employee_name",employeeName);
        map.put("employee_gender",employeeGender);
        map.put("employee_born_date",employeeBornDate);
        map.put("employee_position",employeePosition);
        map.put("employee_account",employeeAccount);
        map.put("employee_password",employeePassword);
        map.put("employee_salary",employeeSalary);
        return map;
    }



    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeBornDate() {
        return employeeBornDate;
    }

    public void setEmployeeBornDate(String employeeBornDate) {
        this.employeeBornDate = employeeBornDate;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }




    public UserIdentity(Map<String,String[]> paramMap){
        try {
            this.warehouseId = paramMap.get("warehouse_id")[0].equals("")||paramMap.get("warehouse_id")[0]==null?null:paramMap.get("warehouse_id")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.employeeName = paramMap.get("employee_name")[0].equals("")||paramMap.get("employee_name")[0]==null?null:paramMap.get("employee_name")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.employeeGender = paramMap.get("employee_gender")[0].equals("")||paramMap.get("employee_gander")[0]==null?null:paramMap.get("employee_gander")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.employeeBornDate = paramMap.get("employee_born_date")[0].equals("")||paramMap.get("employee_born_date")[0]==null?null:paramMap.get("employee_born_date")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.employeeAccount = paramMap.get("employee_account")[0].equals("")||paramMap.get("employee_account")[0]==null?null:paramMap.get("employee_account")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.employeePassword = paramMap.get("employee_password")[0].equals("")||paramMap.get("employee_password")[0]==null?null:paramMap.get("employee_password")[0];
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            this.employeePosition = paramMap.get("employee_position")[0].equals("")||paramMap.get("employee_position")[0]==null?null:paramMap.get("employee_position")[0];
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public UserIdentity() {

    }

    public UserIdentity(String warehouseId, String employeeName, String employeeGander, String employeeBornDate, String employeeAccount, String employeePassword, String employeePosition) {
        this.warehouseId = warehouseId;
        this.employeeName = employeeName;
        this.employeeGender = employeeGander;
        this.employeeBornDate = employeeBornDate;
        this.employeeAccount = employeeAccount;
        this.employeePassword = employeePassword;
        this.employeePosition = employeePosition;
    }

    //    public UserIdentity(String userTheName, String userSex, String bornDate, String userName, String password, String userIdentity) {
//        this.employeeName = userTheName;
//        this.employeeGander = userSex;
//        this.employeeBornDate = bornDate;
//        this.employeeAccount = userName;
//        this.employeePassword = password;
//        this.employeePosition = userIdentity;
//    }


    @Override
    public String toString() {
        return "UserIdentity{" +
                "warehouseId='" + warehouseId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeGander='" + employeeGender + '\'' +
                ", employeeBornDate='" + employeeBornDate + '\'' +
                ", employeeAccount='" + employeeAccount + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                '}';
    }
}
