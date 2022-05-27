<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Update</title>
    <style>
        body{
            position: absolute;
            top: 50%;
            left: 50%;
            margin-right: -50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }
        input{
            width: 250px;
            height:20px;
        }
    </style>
</head>
<body>
<h1>Update user</h1>
<form method="post" action="/update">
    <input type="number" hidden name="id" value="${requestScope.user.id}"/>
    <label><input type="text" name="name" placeholder="Name"/></label><br><br>
    <label><input type="number" name="age" placeholder="Age"/></label><br><br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>
</body>
</html>