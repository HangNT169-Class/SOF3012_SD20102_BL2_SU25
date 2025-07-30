<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 30/7/25
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajax demo</h1>
<button onclick="hienThiDuLieu()">Click me </button>
<div id="result"></div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous"></script>
<script>
    function hienThiDuLieu(){
        $.ajax(
            {
                url:'/api/sinh-vien', // Lay tu ben servlet
                type: 'GET',
                dataType: 'json', // Kieu convert
                success: function (response) {
                    console.log(response)
                    document.getElementById("result").innerHTML =
                        "MSSV: "+ response.ma +
                        "Ten: "+ response.ten
                //     Liet ke not
                },
                error: function () {
                    document.getElementById("result").innerHTML = "Loi roi "
                }
            }
        )
    }
</script>
</body>
</html>
