<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form action="">
      Tên: <input name="ten" />
      <button type="submit">Search</button>
    </form>
    <br />
    <button><a href="">Add Cate</a></button>
    <table border="1">
      <thead>
        <tr>
          <th>STT</th>
          <th>Cate Code</th>
          <th>Cate name</th>
          <th colspan="2">Action</th>
        </tr>
      </thead>
      <tbody>
<%--      for(Doi tuong : lists) : var : doi tuong, items: dai dien cho list
Doi vs bien duoc truyen tu servlet sang : ${ten bien}
--%>
      <c:forEach var="cate" items="${test}">
        <tr>
          <td></td>
          <td>${cate.categoryCode}</td>
          <td>${cate.categoryName}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </body>
</html>
