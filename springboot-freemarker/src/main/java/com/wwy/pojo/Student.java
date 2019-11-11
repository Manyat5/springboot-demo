package com.wwy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;//姓名
    private int age;//年龄
    private Date birthday;//生日
    private List<Student> friends;//朋友列表
    private Student bestFriend;//最好的朋友
}
