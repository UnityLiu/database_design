package com.unityliu;

import com.unityliu.mybatis.dao.UserMapper;
import com.unityliu.pojo.UserIdentity;
import com.unityliu.utils.MybatisUtils;
import com.unityliu.utils.SendEmail;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSession;

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

    public static void main(String[] args) {
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
}
