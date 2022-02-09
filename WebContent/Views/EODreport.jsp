<!DOCTYPE html>
<%@ page import="DAO.DonationListDAO" %>
<%@ page import="Model.ReceiptForm" %>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>


<html>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Raghavendra Trust</title>
</head>
<style>

input[type=text], select {
  width: 100%;
  padding: 3px 6px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 3px;
}

tr:nth-child(even) {background-color: white;}

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
  
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 13.5%;
  height: 512px;
  background: #ccc;
  padding: 10px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 2px;
}

input[type=date], select {
  width: 100%;
  padding: 6px 10px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 6px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: white;
}

div {
  border-radius: 5px;
  background-color: white;
  padding: 10px;
}
</style>
<script> 
        function printDiv() { 
            var divContents = document.getElementById("GFG").innerHTML; 
            var a = window.open('', '', 'height=2000, width=2000'); 
            a.document.write('<html>'); 
            a.document.write('<body >'); 
            a.document.write(divContents); 
            a.document.write('</body></html>'); 
            a.document.close(); 
            a.print(); 
        } 
    </script>
    <script type="text/javascript">
  
	
  $(function() {
	    $( "#datepicker1" ).datepicker({ maxDate: 0,dateFormat: 'dd/mm/yy'});
	    document.getElementById("getres").style.display = "none";
	  });
  </script>
<body style="font-size:20px" onload="document.getElementById('getres').click();">

<jsp:include page="Header.jsp"/>
<section><nav>
<jsp:include page="MenuBar.jsp"/>
</nav>

<%
System.out.println(request.getParameter("date")+" sss");
HttpSession http = request.getSession(false);
String username = http.getAttribute("userName").toString();
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
LocalDateTime now = LocalDateTime.now();  
String timestamp = dtf.format(now);  

%><article>
<div style="float:right"><input type="button" value="print" onclick="printDiv()"></div>
<form action="EODController" method="get">
<input type="text" name="date" id="datepicker1" style="width:30%">
<button id="getre" type="submit">Get Results</button>
<button id="getres" type="submit" onclick="return myFunction()">Get Results</button>
</form>
<div id="GFG"> 
<u>End of the Day Report</u> - <output id="dt">${date }</output><br><br>
Employee : <%= username %><br>
Date & Time : <%= timestamp %> 
<br>
<table id="customers" class="customers" style="font-size:20px">
  <thead>
  <tr>
  <th>
<U>SRI VIJAYEENDRA GHO SAMRAKSHANA</U><br></th></tr>
</thead>
<tbody>
<tr><td>
Cash Received : </td><td>${ vcash } /- </td></tr><tr><td>
Cheque Amount : </td><td>${ vcheque } /- </td></tr><tr><td>
NEFT          : </td><td>${ vneft } /- </td></tr><tr><td>
IMPS          : </td><td>${ vimps } /- </td></tr><tr><td>
UPI           : </td><td>${ vupi } /- </td></tr>
<tr>
<th><U>SRI RAGHAVENDRA SWAMY BRINDAVAN</U></th></tr><br><br>
<tr><td>
Cash Received : </td><td>${ rcash } /- </td></tr><tr><td>
Cheque Amount : </td><td>${ rcheque } /- </td></tr><tr><td>
NEFT          : </td><td>${ rneft } /- </td></tr><tr><td>
IMPS          : </td><td>${ rimps } /- </td></tr><tr><td>
UPI           : </td><td>${ rupi } /- </td></tr>
</tbody></table>
</div> 

    
</article></section>
</body>
<script>
function myFunction() {
  if(document.getElementById("dt").innerHTML != ""){
	  return false;
  }
}
</script>
</html>
