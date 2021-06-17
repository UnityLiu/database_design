package com.unityliu;

import com.unityliu.mybatis.dao.UserMapper;
import com.unityliu.pojo.UserIdentity;
import com.unityliu.utils.MybatisUtils;
import com.unityliu.utils.SendEmail;
import com.unityliu.utils.SqlServerUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main1(String[] args) {
        JSONObject myJson = new JSONObject();
        myJson.put("code",0);
        myJson.put("msg","");
        myJson.put("cout",1);

        JSONObject dataJson01 = new JSONObject();
        dataJson01.element("id",1);
        dataJson01.element("name","Unityliu");


        JSONObject dataJson02 = new JSONObject();
        dataJson02.element("id",2);
        dataJson02.element("name","zjw");

        JSONArray myJsonArray = new JSONArray();
        myJsonArray.add(dataJson01);
        myJsonArray.add(dataJson02);

        myJson.element("data",myJsonArray);

        System.out.println(myJson.toString());

    }

    public static void main2(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String unityliu = mapper.checkUserName("unityliu");
        System.out.println(unityliu);
    }

    public static void main3(String[] args) {
        //邮箱测试
        SendEmail sendEmail = new SendEmail();
        sendEmail.setReceiveMailAccount("unityliu@163.com");
        sendEmail.setInfo("我是你爹");
        try {
            int i = 1;
            while(i-->0){
                sendEmail.Send();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main4(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        System.out.println(mapper.checkUserName("unityliu@qq.com"));

        mapper.addUser(new UserIdentity("001","刘家乐","男","2001-12-02","unityliu@qq.com","asdf","仓库管理员"));
        sqlSession.commit();
        sqlSession.close();
    }

    public static void main5(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<UserIdentity> employees = mapper.getAllEmployees();

        JSONObject result = new JSONObject();
        result.put("code",0);
        result.put("msg","");
        result.put("count",0);

        JSONArray dataArray = new JSONArray();

        for (UserIdentity employee : employees) {
            JSONObject dataInnerJson = new JSONObject();

            dataInnerJson.put("warehouse_id",employee.getWarehouseId());
            dataInnerJson.put("employee_name",employee.getEmployeeName());
            dataInnerJson.put("employee_gender",employee.getEmployeeGender());
            dataInnerJson.put("employee_born_date",employee.getEmployeeBornDate());
            dataInnerJson.put("employee_position",employee.getEmployeePosition());
            dataInnerJson.put("employee_salary",employee.getEmployeeSalary());

            dataArray.add(dataInnerJson);
        }

        result.put("data",dataArray);

        System.out.println(result.toString());

    }

    public static void main6(String[] args) {
        ArrayList<String> paramList = new ArrayList<>();

        //设置数据库中要返回的列
        paramList.add("warehouse_id");
        paramList.add("employee_account");
        paramList.add("employee_name");
        paramList.add("employee_gender");
        paramList.add("employee_born_date");
        paramList.add("employee_position");
        paramList.add("employee_salary");
        SqlSession sqlSession = MybatisUtils.getSessionFactory().openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


//        System.out.println(SqlServerUtils.getAllEmployees(paramList));
    }

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("data",1);
        json.put("data2",2);
        json.put("data",3);
        System.out.println(json);
    }
}
