<%--
  Created by IntelliJ IDEA.
  User: perennial
  Date: 20/11/20
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container" align="center"><h1>Register</h1></div>
<div class="alert alert-danger" role="alert">
    <form:errors path="register.*"></form:errors>
</div>
<form action="handleform" method="post">
    <label>Name:
        <input type="text" name="pname">
    </label>
    <label>id:
        <input type="text" name="id">
    </label>
    <label>Date of birth:
        <input type="text" name="date">
    </label>
    <label>
        Course:
        <select name="courses" multiple="multiple">
            <option>java</option>
            <option>python</option>
            <option>C++</option>
            <option>data Base</option>
        </select>
    </label>
    <label>
        Gender:
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">Male</label><br>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">Female</label><br>
        <input type="radio" id="other" name="gender" value="other">
        <label for="other">Other</label>

    </label>
    <label>
        Select type:
        <select name="type">
            <option>New</option>
            <option>Old</option>
        </select>
    </label>
    <label>
        Address:
        <input type="text" name="address.street">
        <input type="text" name="address.city">
    </label>
    <button type="submit">Submit</button>
</form>
</body>
</html>
