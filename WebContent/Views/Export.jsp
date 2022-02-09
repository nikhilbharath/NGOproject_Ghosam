<%@ page import="java.util.ArrayList"%> 
<%@page import="java.util.Iterator"%> 
<%@ page import="DAO.DonationListDAO" %>
<%@ page import="Model.ReceiptForm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
 <title>Raghavendra Trust</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css"/>
	 <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">

  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
  
  <script type="text/javascript">
  
	
  $(function() {
	    $( "#from" ).datepicker({ dateFormat: 'dd/mm/yy'});
	  });
	  
	$(function() {
	    $( "#to" ).datepicker({ dateFormat: 'dd/mm/yy'});
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
<script>
$(document).ready( function () {
    $('#customers').DataTable({
        dom: 'Bfrtip',
        buttons: [
        	
            'excelHtml5',
            'csvHtml5',
            'pdfHtml5'
        ]
    });
} );


</script>
<body style="font-size:20px">
<jsp:include page="Header.jsp"/>
<section><nav>
<jsp:include page="MenuBar.jsp"/>
</nav>
<article>
<br>
<form action="ExportList">&nbsp;&nbsp;
<label for="from">From Date</label>&nbsp;&nbsp;
    <input type="text" name="from" style="width:10%" id="from">&nbsp;&nbsp;
    <label for="to">To Date</label>&nbsp;&nbsp;
    <input type="text" name="to" style="width:10%" id="to">&nbsp;&nbsp;
    <input type=submit>
</form>
<br>
<div>
  
      <table id="customers" class="customers" style="font-size:20px">
      <thead> 
         <tr> 
          <th>S No</th>
  <th>Receipt No</th>
  <th>Name</th>
  <th>Amount</th>
  <th>Trust</th>

         </tr> </thead><tbody>
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
        <% 
        ArrayList<ReceiptForm> std = new ArrayList<ReceiptForm>();
        std = (ArrayList<ReceiptForm>)request.getAttribute("data"); 
        if(std != null){
        int sno=1;
        for(ReceiptForm s:std){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=sno%></td>
 <td><%=s.getReceiptno()%></td>
 <td><%=s.getDonar_Name()%></td>
 <td><%=s.getAmount()%></td>
 <td><%=s.getTrustID().getTrustName()%></td> 
            </tr> 
            <%sno++;}}%> 
      </tbody>  </table> 
</div>
</article></section>
</body>
</html>

