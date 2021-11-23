<%--
  Created by IntelliJ IDEA.
  User: qj95j
  Date: 2021/10/31
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<fieldset><legend>BMI Calculator</legend>
    <form action="/bmiResult" method="post">
    height<input name="height">cm
    weight<input name="weight">kg
    <input type="submit" value="submit">
    </form>
    <form action="/bmiResultInMav" method="post">
        height<input name="height">cm
        weight<input name="weight">kg
        <input type="submit" value="submit">
    </form>
</fieldset>
</body>
</html>
