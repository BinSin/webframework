<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Form</title>
</head>
<body>
<center><h2 style="center">A Sample Form</h2></center>
<form name="order" method="post" action="/homework1/doPurchase">
Item Number: <input type="text" name="itemNumber" /><br/>
Description: <input type="text" name="description" /><br/>
Price Each: <input type="text" name="price" /><br/>
<hr>
First Name: <input type="text" name="first" /><br/>
Last Name: <input type="text" name="last" /><br/>
Middle Initial: <input type="text" name="initial" /><br/>
Shipping Address:<textarea rows="3" cols="40" name="address"></textarea><br/>
Credit Card: <br/>
<input type="radio" name="cardType" value="Visa" />Visa<br/>
<input type="radio" name="cardType" value="MasterCard" />MasterCard<br/>
<input type="radio" name="cardType" value="American Express" />American Express<br/>
<input type="radio" name="cardType" value="Discover" />Discover<br/>
<input type="radio" name="cardType" value="Java SmartCard" />Java SmartCard<br/>
Credit Card Number: <input type="password" name="cardNumber" /><br/>
Repeat Credit Card Number: <input type="password" name="repeat" /><br/>
<center><input type="submit" value="Submit Order" /></center>
</form>
</body>
</html>