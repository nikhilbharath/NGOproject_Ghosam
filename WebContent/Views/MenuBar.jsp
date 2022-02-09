<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 150px;
  background-color: #f1f1f1;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #10a910;
  color: white;
}

li a:hover:not(.active) {
  background-color: #10a910;
  color: white;
}
</style>

</head>
<body>
<%
String name= (String)session.getAttribute("userName");  
%>
<output id="acl" style="display:none"><%=name%></output>
<ul>
  <li><a href="/GhoSam/Views/HomePage.jsp">Home</a></li> 
  <li id="jo1"><a href="/GhoSam/Views/Recent_updates.jsp">Events</a></li>
  <li id="jo2"><a href="/GhoSam/Views/BookingForm.jsp">Donation Form</a></li>
  <li id="jo3"><a href="/GhoSam/Views/DonationList.jsp">View Donations</a></li>
  <li id="jo4"><a href="/GhoSam/Views/Export.jsp">Reports</a></li>
  <li id="jo5"><a href="/GhoSam/Views/EODreport.jsp">Report EOD</a></li>
 <li><a href="/GhoSam/Logout">Logout</a></li>
</ul>

</body>
<script>
if(document.getElementById("acl").innerHTML == 'counter'){
document.getElementById("jo1").style.display = "none";
document.getElementById("jo4").style.display = "none";
document.getElementById("jo5").style.display = "none";
}
</script>
</html>

