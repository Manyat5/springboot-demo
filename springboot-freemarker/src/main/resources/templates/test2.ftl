<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello World!</title>
</head>
<body>
    <table>
        <tr>
            <td>序号</td><td>姓名</td><td>年龄</td>
        </tr>
        <#list stus as stu>
            <tr>
                <td>${stu_index+1}</td>
                <td <#if stu.name=='ls'>style="background:blue;"</#if>>${stu.name}</td>
                <td>${stu.age}</td>
                <td>${stu.birthday?date}</td>
            </tr>
        </#list>
    </table>
    <br/>
    age=${stuMap['stu1'].age}
    name=${stuMap.stu1.name}
_________________________________<br/>
<#list stuMap?keys as key>
    年龄：${stuMap[key].name}
</#list>
</body>
</html>