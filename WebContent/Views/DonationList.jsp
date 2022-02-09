<%@ page import="java.util.ArrayList"%> 
<%@page import="java.util.Iterator"%> 
<%@ page import="DAO.DonationListDAO" %>
<%@ page import="Model.ReceiptForm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Raghavendra Trust</title>
</head>
 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
	 
	 <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>


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
<script>
$(document).ready( function () {
    $('#customers').DataTable();
} );

</script>


<body style="font-size:20px">
<jsp:include page="Header.jsp"/>
<section><nav>
<jsp:include page="MenuBar.jsp"/>
</nav>
<article>

<div>
  <table id="customers" class="customers" style="font-size:20px">
  <thead>
  <tr>
  <th>S No </th>
  <th>Receipt No</th>
  <th>Name</th>
  <th>Amount</th>
  <th>Trust</th>
  <th></th><th></th>
  </tr> </thead><tbody><tr>
<%
// Iterating through subjectList
DonationListDAO instance = new DonationListDAO();
  // Null check for the object
  ArrayList<ReceiptForm> a = new ArrayList<ReceiptForm>();
a = instance.getList();
 Iterator<ReceiptForm> iterator = a.iterator();  // Iterator
 int sno = 1;
 while(iterator.hasNext())  // iterate through all the data until the last record
 {
	 ReceiptForm empDetails = iterator.next(); //assign individual employee record to the employee class object
	
 %>
<td><%=sno%></td>
<td style="display:none;"><%=empDetails.getRid()%></td>
 <td><%=empDetails.getReceiptno()%></td>
 <td><%=empDetails.getDonar_Name()%></td>
 <td><%=empDetails.getAmount()%></td>
 <td><%=empDetails.getTrustID().getTrustName()%></td>
 <td><a id="aa" href="table1.jsp?id=<%out.print(empDetails.getRid());%>">Edit</a></td>  
<td><a id="bb" href="DeleteFormController?id=<%out.print(empDetails.getRid());%>">Delete</a></td>
 </tr>
 <%
sno++;
 }

%>
</tbody>
</table>
</div>
</article></section>

</body>
</html>

