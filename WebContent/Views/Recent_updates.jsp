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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Raghavendra Trust</title>
</head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
	 
	 <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>

<script type="text/javascript">
  
	
  $(function() {
	    $( "#datepicker1" ).datepicker({ minDate: 0,dateFormat: 'dd/mm/yy'});
	  });
	  
	
	</script>
<script src="src/fancyTable.js"></script>
<style>

#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
article {
  float: left;

  width: 82%;
  background-color: white;
  
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
  height: 100%;
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
  width: 50%;
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

<body style="font-size:20px">
<jsp:include page="Header.jsp"/>
<section><nav>
<jsp:include page="MenuBar.jsp"/>
</nav>
<article>


<div class="row">
  <div class="column">
    <h2>Upcoming Sevas </h2>
   <table id="customers" class="customers">
  <thead>
  <tr>
  <th>Date</th>
  
  <th>Seva</th>
   <th>Trust</th>
   <th>Donor Name</th>
  
  
  </tr> </thead><tbody><tr>
<%
// Iterating through subjectList
EventDAOImpl instance = new EventDAOImpl();
  // Null check for the object
  ArrayList<ReceiptForm> a = new ArrayList<ReceiptForm>();
a = instance.getList();
 Iterator<ReceiptForm> iterator = a.iterator();  // Iterator

 while(iterator.hasNext())  // iterate through all the data until the last record
 {
	 ReceiptForm empDetails = iterator.next(); //assign individual employee record to the employee class object
 %>

 <td><%=empDetails.getPaymentDate()%></td>
 
 <td><%=empDetails.getScheme().getPoojaScheme()%></td>
 <td><%=empDetails.getTrustID().getTrustName()%></td>
 <td><%=empDetails.getDonar_Name()%></td>
 </tr>
 <%

 }

%>
</tbody>
</table>
  </div>
  
  <div class="column">
    <h2>Upcoming Events</h2>
    <form action="EventForm" id="eventform">
<table id="customers" class="customers">
  <thead>
  <tr>
  <th>Date</th>
  <th>Events</th>
  <th></th>
  
  
  
  </tr><tr><td><input type="text" name="date" style="width:50%" id="datepicker1" required></td>
  <td><input type="text" id="eventname" name="eventname" placeholder="Event name" style="width:50%" required></td>
  <td><button value="add" type="submit"><i class="fa fa-plus"></i></button></td></tr> </thead><tbody><tr>
<%
// Iterating through subjectList

  // Null check for the object
  ArrayList<EventMaster> b = new ArrayList<EventMaster>();
	b = instance.getEvents();
 Iterator<EventMaster> iterator1 = b.iterator();  // Iterator

 while(iterator1.hasNext())  // iterate through all the data until the last record
 {
	 EventMaster empDetails = iterator1.next(); //assign individual employee record to the employee class object
 %>

 
 <td><%=empDetails.getEventdate()%></td>
 
 <td><%=empDetails.getEventdesc()%></td>
 <td><a style="color: red" href='DeleteEventController?id=<%out.print(empDetails.getSno());%>'><i class="fa fa-minus"></i></a>

 </tr>
 <%

 }

%>
</tbody>
</table>
</form>
  </div>
  
  
</div>
</article>

</section>
</body>
</html>

