<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 28/7/25
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--
Filter: authentication and authorization
- Authen: Check ton tai trong he thong hay khong - lop bao mat 1
- Author: Phan quyen nguoi dung => tk phai ton tai trong he thong
401 & 403
401: Khi tai khoan khong ton tai trong he thong (Khong xac thuc) - authen
403: Tai khoan khong du quyen truy cap vao he thong (Khong du quyen) - author
--%>
<body>
<h1>${error}</h1>
    <form action="/login" method="POST">
        Username: <input name="uname1"/>
        <br/>
        Password: <input name="pass"/>
        <br/>
        <button type="submit">Login</button>
    </form>
</body>
</html>
