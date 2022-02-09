<%@ page import="java.util.ArrayList"%> 
<%@page import="java.util.Iterator"%> 
<%@ page import="DAO.EventDAOImpl" %>
<%@ page import="Model.ReceiptForm" %>
<%@ page import="Model.EventMaster" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
	 
	 <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>


<script src="src/fancyTable.js"></script>
<style> 
.td {
  width: 100px;
  height: 100px;
  
 }

@keyframes myfirst {
  0%   { background: #F1F1F1 ;left: 0px; top: 250px;color:red;}
  5%   { background: #F1F1F1 ;left: 0px; top: 237px;color:red;}
  10%  {background: #F1F1F1 ; left: 0px; top: 225px;color:red;}
  15%   { background: #F1F1F1 ;left: 0px; top: 212px;color:red;}
  20%  {background: #F1F1F1 ; left: 0px; top: 200px;color:red;}
  25%   { background: #F1F1F1 ;left: 0px; top: 187px;color:red;}
  30%  {background: #F1F1F1 ; left: 0px; top: 175px;color:red;}
  35%   { background: #F1F1F1 ;left: 0px; top: 162px;color:red;}
  40% {background: #F1F1F1 ; left: 0px; top: 150px;color:red;}
  45%   { background: #F1F1F1 ;left: 0px; top: 137px;color:red;}
   50% {background: #F1F1F1 ; left: 0px; top: 125px;color:red;}
   55%   { background: #F1F1F1 ;left: 0px; top: 112px;color:red;}
    60% {background: #F1F1F1 ; left: 0px; top: 100px;color:red;}
    65%   { background: #F1F1F1 ;left: 0px; top: 87px;color:red;}
     70% {background: #F1F1F1 ; left: 0px; top: 75px;color:red;}
     75%   { background: #F1F1F1 ;left: 0px; top: 62px;color:red;}
      80% {background: #F1F1F1 ; left: 0px; top: 50px;color:red;}
      85%   { background: #F1F1F1 ;left: 0px; top: 37px;color:red;}
       90% {background: #F1F1F1 ; left: 0px; top: 25px;color:red;}
       95%   { background: #F1F1F1 ;left: 0px; top: 12px;color:red;}
        100% {background: #F1F1F1 ; left: 0px; top: 0px;color:red;}
}
</style>
<style>

.slide{
animation: myfirst 10s 500;
  animation-direction: normal;
  position: relative;
  background-color: #F1F1F1;
}

.menu {
  width: 50%;
  float: left;
  height:230px;
  
}

.main {
  width: 25%;
  float: left;
  height:540px;
 
}
.side {
  width: 25%;
  float: left;
 
  
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 13.5%;
  height: 482px;
  background: #ccc;
  padding: 10px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 2px;
}
div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 10px;
  
}
</style>
<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
}

/* Style the header */
.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 100%;
  height : 500px;
  padding: 15px;
  
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width:600px) {
  .column {
    width: 100%;
  }
}
</style>
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
  text-align:center;
  font-weight: bold;
}


/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 4px;
    text-align: center;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    border-radius: 4px;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #D3D3D3;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
    text-align: center;
}

span.psw {
    float: right;
    padding-top: 16px;
}


/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

.loginbtn {
    background-color: #4CAF50;
    color: white;
    
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 50%;
    opacity: 0.9;
    text-align: center;
}

.loginbtn:hover {
    opacity: 1;
}
/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}


/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<script> 
function validate()
{ 
var username = document.form.j_username.value; 
var password = document.form.j_password.value;
if (username==null || username=="")
{ 
alert("Username cannot be blank"); 
return false; 
}
else if(password==null || password=="")
{ 
alert("Password cannot be blank"); 
return false; 
} 
}
</script> 
</head>
<body>

<div class="header">
  <div class="a">SRI VIJAYEENDRA GHO-SAMRAKSHANA TRUST (REGD)</div>
  
  
</div>
<div class="menu">
<img src="ragsss.JPG" style="width:100%;height:250%">
</div>
<div class="main">
<span style="color:red">${error }</span><br>
${msg }<br>
<form name="form" method="post" action="LoginServlet">
    
      <label for="uname"><b>Username</b></label>&nbsp;&nbsp;&nbsp;
      <input type="text" placeholder="Enter Username" name="j_username" required>
		<br>
      <label for="psw"><b>Password</b></label>&nbsp;&nbsp;&nbsp;
      <input type="password" placeholder="Enter Password" name="j_password" required>
        <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <button type="submit" class="loginbtn">Login</button>
      
    

  </form>
</div>
<div class="side">
<div class="row">
  <div class="column">
    <h2>Upcoming Events</h2>
 <div class="slide">
<%
// Iterating through subjectList
EventDAOImpl instance = new EventDAOImpl();
  // Null check for the object
  ArrayList<ReceiptForm> a = new ArrayList<ReceiptForm>();
		  
		  try{
		  
	a = instance.getList();
	if(a != null){
		  
 Iterator<ReceiptForm> iterator = a.iterator();  // Iterator

 while(iterator.hasNext())  // iterate through all the data until the last record
 {
	 ReceiptForm empDetails = iterator.next(); //assign individual employee record to the employee class object
 %>
<%=empDetails.getPaymentDate()%> : <%=empDetails.getScheme().getPoojaScheme()%><br><br><%} %>
 <%
 ArrayList<EventMaster> b = new ArrayList<EventMaster>();
 b = instance.getEvents();
  Iterator<EventMaster> iterator1 = b.iterator();  // Iterator

  while(iterator1.hasNext())  // iterate through all the data until the last record
  {
 	 EventMaster empDetails = iterator1.next();  //assign individual employee record to the employee class object


%>
  <%=empDetails.getEventdate()%> : <%=empDetails.getEventdesc()%><br><br>
 
<%}}}catch(Exception e){

}%>

  </div>
  </div>
</div>
</div>

</body>
</html>
