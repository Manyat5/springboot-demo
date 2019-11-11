package com.wwy.test;

import com.wwy.pojo.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FreemarkerTest {
    @Test
    public void testGenerateHtml() throws Exception{
        //定义配置类
        Configuration configuration=new Configuration(Configuration.getVersion());
        //定义模板路径
        String path = this.getClass().getResource("/").getPath();
        //定义模板
        configuration.setDirectoryForTemplateLoading(new File(path+"/templates/"));
        //获取模板文件的内容
        Template template = configuration.getTemplate("test2.ftl");
        //定义数据模型
        Map map=getMap();
        //静态化获取到内容
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        System.out.println(content);
        //通过输出流来输出
    }

    public Map getMap(){
        Map map=new HashMap();
        //list数据
        Student stu1 = new Student("zs",10,new Date(),null,null);
        Student stu2=new Student("ls",20,new Date(),null,stu1);
        List<Student> stus=new ArrayList<Student>();
        stus.add(stu1);stus.add(stu2);
        map.put("stus",stus);
        //准备map数据
        HashMap<String,Student> stuMap = new HashMap<String, Student>();
        stuMap.put("stu1",stu1);
        stuMap.put("stu2",stu2);
        map.put("stuMap",stuMap);
        return map;
    }
}
