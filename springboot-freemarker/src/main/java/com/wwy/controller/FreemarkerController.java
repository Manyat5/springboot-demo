package com.wwy.controller;

import com.wwy.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class FreemarkerController {
    @GetMapping("/test1")
    public String test1(Map<String,Object> map,Model model){
        map.put("name","freemarker");
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(Map<String,Object> map){
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
        return "test2";
    }
}
