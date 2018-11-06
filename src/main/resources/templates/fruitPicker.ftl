<!DOCTYPE html>
<html lang="en">
<head>
    <title>Fruit picker</title>
</head>
<body>
    <input action="/form" method="post">
        <p>What is your favourite fruit</p>
        <!--<#list fruits as fruit>-->
        <p><input type="radio" name="fruit" value="${fruit}">${fruit}</input></p>
        <!--<#list>-->
        <input type="submit" name="Submit"/>
    </form>
</body>
</html>