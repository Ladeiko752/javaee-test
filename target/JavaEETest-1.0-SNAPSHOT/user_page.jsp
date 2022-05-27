<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <style>
        input{
            width: 250px;
            height:20px;
        }
    </style>
</head>
<body style="text-align: center">
<h1>All users</h1>

<c:forEach var = "user" items = "${requestScope.users}">
    <var style="font-size: 15px">
        <p>
            <b>Name: ${user.name}</b><br>
            <b>Age: ${user.age}</b>
        </p>
    </var>

    <form method="post" action="/delete">
        <input type="number" hidden name="id" value="${user.id}">
        <input type="submit" name="delete" value="Delete">
    </form>

    <form method="get" action="/update">
        <input type="number" hidden name="id" value="${user.id}">
        <input type="submit" name="update" value="Update">
    </form>

    <hr style="width: 350px">
</c:forEach>


<h1>Add new user</h1>

<form method="post" action="/add_user" style="text-align: center">

    <label><input type="text" name="name" placeholder="Name"></label><br><br>

    <label><input type="number" name="age" placeholder="Age"></label><br><br>

    <input type="submit" value="Ok" name="Ok"><br><br>
</form>

</body>
</html>