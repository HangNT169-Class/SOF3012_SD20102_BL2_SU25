<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 21/7/25
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select>
    <c:forEach items="${listCate}" var="ca">
        <option value="${ca.id}">${ca.categoryName}</option>
    </c:forEach>
</select>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Name</th>
        <th>price</th>
        <th>description</th>
        <th>Cate Code</th>
        <th>Cate Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="pro">
        <tr>
            <td>${pro.id}</td>
            <td>${pro.productCode}</td>
            <td>${pro.productName}</td>
            <td>${pro.price}</td>
            <td>${pro.description}</td>
            <td>${pro.cate.categoryCode}</td>
            <td>${pro.cate.categoryName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
