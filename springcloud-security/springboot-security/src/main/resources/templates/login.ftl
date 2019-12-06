<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>自定义登录页面</title>
</head>
<body>
    <form method="post" action="/login">
        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
        用户名: <input name="username"><br/>
        密码：<input type="password" name="password"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>