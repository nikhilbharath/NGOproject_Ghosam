<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Model.NatchatramMaster" %>
<%@ page import="Model.PaymentModeMaster" %>
<%@ page import="Model.PoojaSchemeMaster" %>
<%@ page import="Model.RaasiMaster" %>
<%@ page import="Model.ReceiptForm" %>
<%@ page import="DAO.FormDAOImpl" %>
<%@page import="java.sql.*"%>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<head>
  <title>Raghavendra Trust</title>
</head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
  <script>  
  function showAlert(){
	  var s = document.forms["findform"]["resp"].value;
	  if(s == 'No'){
		  alert("Please enter a valid input")
	  }
  }
</script>
  <script type="text/javascript">
  
	
  $(function() {
	    $( "#datepicker1" ).datepicker({ minDate: 0,dateFormat: 'dd/mm/yy'});
	  });
	  
	$(function() {
	    $( "#datepicker2" ).datepicker({ minDate: 0,maxDate: 0,dateFormat: 'dd/mm/yy'});
	  });
  
  
  var xmlHttp
  function showState(str){
  if (typeof XMLHttpRequest != "undefined"){
  xmlHttp= new XMLHttpRequest();
  }
  else if (window.ActiveXObject){
  xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
  }
  if (xmlHttp==null){
  alert("Browser does not support XMLHTTP Request")
  return;
  } 
  var url="db_fetch.jsp";
  url +="?count=" +str;
  xmlHttp.onreadystatechange = stateChange;
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);
  }
  
  
  function showScheme(str){
  if (typeof XMLHttpRequest != "undefined"){
  xmlHttp= new XMLHttpRequest();
  }
  else if (window.ActiveXObject){
  xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
  }
  if (xmlHttp==null){
  alert("Browser does not support XMLHTTP Request")
  return;
  } 
  var url="scheme_fetch.jsp";
  url +="?count=" +str;
  xmlHttp.onreadystatechange = stateChanges;
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);
  }

  
  function stateChange(){   
  if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
  document.getElementById("raasi").innerHTML=xmlHttp.responseText   
  }   
  }
  
  function stateChanges(){   
	  if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
	  document.getElementById("scheme").innerHTML=xmlHttp.responseText   
	  }   
	  }
  
  
  function closePrint () {
	  document.body.removeChild(this.__container__);
	}
  
  

	function setPrint () {
	  this.contentWindow.__container__ = this;
	  this.contentWindow.onbeforeunload = closePrint;
	  this.contentWindow.onafterprint = closePrint;
	  this.contentWindow.focus(); // Required for IE
	  this.contentWindow.print();
	}

	function printPage (sURL) {
	  var oHiddFrame = document.createElement("iframe");
	  oHiddFrame.onload = setPrint;
	  oHiddFrame.style.position = "fixed";
	  oHiddFrame.style.right = "0";
	  oHiddFrame.style.bottom = "0";
	  oHiddFrame.style.width = "0";
	  oHiddFrame.style.height = "0";
	  oHiddFrame.style.border = "0";
	  oHiddFrame.src = sURL;
	  document.body.appendChild(oHiddFrame);
	}
	
	function loadOtherPage() {

	    $("<iframe>")                             // create a new iframe element
	        .hide()                               // make it invisible
	        .attr("src", "/FormController")       // point the iframe to the page you want to print
	        .appendTo("body");                    // add iframe to the DOM to cause it to load the page

	}
	
	
</script>

<style>

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

table {
 
  width: 100%;
   table-layout: fixed ;
}

th, td {
width: 25% ;
  padding: 3px;
}

tr:nth-child(even) {background-color: #f2f2f2;}

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

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 4px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=text], input[type=number],select {
 width: 100%;
  padding: 6px 20px;
  margin: 1px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  }

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 10px;
}
</style>
<body>
<jsp:include page="Header.jsp"/>
<section><nav>
<jsp:include page="MenuBar.jsp"/>
</nav>
<article>
 <div>
 <form action="PassObjectForm" method="get" name="dssform" onsubmit="return validateForms()" id="findform" >
 <label for="contact">Find user</label>&nbsp;&nbsp;&nbsp;
    <input type="text" id="contact" style="width:30%" name="contact" placeholder="Please enter the name or contact .."  list="browsers"> 
     <datalist id="browsers">
     <%
     FormDAOImpl instance = new FormDAOImpl();
     HashMap<Integer,String> list31 = instance.getCntlist();
     if(list31 != null){
     for(Integer key:list31.keySet()){
    	 String noSpaceStr = list31.get(key).replaceAll("\\s", "_");
         out.println("<option value="+noSpaceStr+"></option>");
     }
     }
    %>
   
  </datalist>
  <input type="hidden" value="${resp}" id="resp" name="resp" onchange="showALert()">
  <input type="submit" style="width:100px">
 </form><div style="float:right"><button id="myBtn" value="Confirm">Confirm</button></div>
 
 </div>
  <script>
function validateForms() {
  var x1 = document.forms["dssform"]["contact"].value;
 
  if (x1 == "" || x1 == null ) {
    alert("No user found with the given input");
    return false;
  }
}
</script>
 <div><form action="FormController" method="post" name="dform" style="font-size:20px" onsubmit="return validateForm()">
    <table style="overflow-x:auto;font-size:20px">
    
    <tr><th>
    <label for="muttbranch">Voucher Type *</label></th><td>
    <select id="muttbranch" name="muttbranch"  onchange="showScheme(this.value)">
    <option value='-1'>Select</option>
     <%
     ReceiptForm r = new ReceiptForm();
     HttpSession session1 = request.getSession(true);
     r = (ReceiptForm)session1.getAttribute("reqObj");
     instance.populate_dropdowns();
     HashMap<Integer,String> list0 = instance.getT().getTrustlist();
     
     
    for(Integer key:list0.keySet()){
        out.println("<option value="+key+">"+list0.get(key)+"</option>");
    }
    %></select></td>
    <th><label for="date">Seva Date *</label></th>
    <td><input type="text" name="date"  id="datepicker1"></td>
    </tr>
    <tr><th><label for="fname">Name *</label></th>
    <td><input type="text" id="fname" name="firstname" placeholder="Your name.."  value="${ra.donar_Name }"></td>
    <th>
    <label for="contact">Contact Number *</label></th>
    <td><input type="number" id="contact" name="contact" placeholder="Your Contact .."  min="1000000000" max="9999999999" value="${ra.contact_No }"> 
     </td>
</tr>
    <tr><th><label for="add1">Address Line1 *</label></th>
    <td>
    <input type="text" id="add1" name="address1" placeholder="Your door no and street.."  value="${ra.donar_AddressLine1 }"></td>
    <th>
    <label for="add2">Address Line2 *</label></th>
    <td><input type="text" id="add1" name="address2" placeholder="Your Area .."  value="${ra.donar_AddressLine2 }"></td></tr>
    <tr><th>
    <label for="city">City *</label></th>
    <td><input type="text" id="city" name="city" placeholder="Your City .."  value="${ra.donar_City }"></td>
    <th>
    <label for="pinc">Pin code *</label></th>
    <td><input type="number" id="pinc" name="pinc" placeholder="Your Pincode .."  value="${ra.donar_Pin }"></td></tr>
    <tr>
    <th>
    <label for="amt">Amount *</label></th>
    <td><input type="number" id="amt" name="amt" placeholder="Donation Amount .."  onkeyup="searchInfo()"><br><span id="mylocation" style="font-size:15;color:red;font-weight:bold"></span></td>
    <th>
    <label for="scheme">Scheme Name *</label></th>
    <td><select id="scheme" name="scheme" >
    <option value='${ra.scheme.poojaSchemeID}'>${ra.scheme.poojaScheme}</option>
     </select></td></tr>
	<tr><th><label for="star">Nakshatram *</label></th>
    <td><select id="star" name="star"  onchange="showState(this.value)">
    <option selected value='${ra.natchatram.natchatramID}'>${ra.natchatram.natchatramName}</option>
    <%
     HashMap<Integer,String> list1 = instance.getN().getStarlist();
     
     
    for(Integer key:list1.keySet()){
        out.println("<option value="+key+">"+list1.get(key)+"</option>");
    }
    %>
     </select></td>
    
    <th><label for="pan">Gothram *</label></th>
    <td><input type="text" id="gothram" name="gothram" placeholder="Your Gothram .."  value="${ra.gothram }"></td>
    </tr><tr>
    <th><label for="raasi">Raasi *</label></th>
    <td><select id="raasi" name="raasi" >
   <option selected value='${ra.raasi.raasiID}'>${ra.raasi.raasiName}</option>
     </select></td>
    
     <th><label for="pan">PAN Number</label></th>
    <td><input type="text" id="pan" name="pan" placeholder="Your Pan No .."  value="${ra.donar_PAN }"></td>
    <tr>
    <th>
    <label for="payment">Payment Mode *</label></th>
    <td><select id="payment" name="payment" >
     <%
     HashMap<Integer,String> list3 = instance.getPay().getPaylist();
     
     
    for(Integer key:list3.keySet()){
        out.println("<option value="+key+">"+list3.get(key)+"</option>");
    }
    %></select></td>
    <th>
    
    <label for="paydate">Payment Date *</label></th>
    <td><input type="text" name="paydate"  id="datepicker2"></td></tr>
    <tr>
    <th>
    <label for="paydesc">Payment Description </label></th>
    <td colspan="3"><textarea rows="4" cols="50" name="paydesc" id="payd">

</textarea></td></tr>
   <tr><td> <p>

    
   
   </p>
    </td>
    </tr>
  </table>
  <!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <p>
     TRUST : <output id="j15"></output><br>
   DATE : <output id="j1"></output><br>
   NAME : <output id="j2"></output><br><br>
  
    ADDRESS <br>
    <output id="j3"></output><br>
    <output id="j4"></output><br><br>
    CONTACT : <output id="j5"></output><br>
    SCHEME : <output id="j6"></output> <br>
    PAYMENT DATE : <output id="j7"></output><br>
    OTHER PARTICULAR : <output id="j8"></output> / <output id="j9"></output> / <output id="j10"></output><br>
    PAN : <output id="j11"></output><br>
    MODE OF PAYMENT : <output id="j12"></output><br><br>
   
    AMOUNT : <output id="j13"></output><br><br>
    <button id="submit" type="submit" value="Save">Save</button>
   	
  </div>

</div>
    </form>
     </div>
  

</article></section>
</body>
</html>
<script>  
var request=new XMLHttpRequest();  
function searchInfo(){  

var name=document.dform.amt.value;  
var url="amtwords.jsp?val="+name;  

try{  
request.onreadystatechange=function(){  
if(request.readyState==4){  
var val=request.responseText;  

document.getElementById('mylocation').innerHTML=val;  
}  
}//end of function  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
</script>
<script>  
  
	  var s = document.forms["findform"]["resp"].value;
	  if(s == 'No'){
		  alert("Please enter an existing user info")
		 
		  document.forms["findform"]["resp"].value = "";
	  }
  
</script>
<script>

function validateForm() {
  var x1 = document.forms["dform"]["muttbranch"].value;
  
 
  var x2 = document.forms["dform"]["date"].value;
  var x3 = document.forms["dform"]["firstname"].value;
  var x4 = document.forms["dform"]["contact"].value;
  var x5 = document.forms["dform"]["address1"].value;
  var x6 = document.forms["dform"]["address2"].value;
  var x7 = document.forms["dform"]["city"].value;
  var x8 = document.forms["dform"]["pinc"].value;
  var x9 = document.forms["dform"]["amt"].value;
  var x10 = document.forms["dform"]["scheme"].value;
  var x11 = document.forms["dform"]["star"].value;
  var x12 = document.forms["dform"]["gothram"].value;
  var x13 = document.forms["dform"]["raasi"].value; 
  var x14 = document.forms["dform"]["pan"].value;
  var x15 = document.forms["dform"]["payment"].value;
  var x16 = document.forms["dform"]["paydate"].value;
  var x17 = document.forms["dform"]["paydesc"].value; 
  
 
  if (x1 == -1 || x2 == "" || x3 == "" || x4 == 0 || x4 == "" 
		  || x5 == "" || x6 == "" || x7 == "" || x8 == 0 || x9 == 0 || x10 == -1 ||
		   x16 == "" || x15 == 0 ) {
    alert("Please fill all the input fields");
    return false;
  }else{
	  
	  var sel = document.forms["dform"]["muttbranch"];
	  var x1 = sel.options[sel.selectedIndex].text;
	  var sel = document.forms["dform"]["scheme"];
	  var x10 = sel.options[sel.selectedIndex].text;
	  var sel = document.forms["dform"]["star"];
	  var x11 = sel.options[sel.selectedIndex].text;
	  var sel = document.forms["dform"]["raasi"];
	  var x13 = sel.options[sel.selectedIndex].text;
	  var sel = document.forms["dform"]["payment"];
	  var x15 = sel.options[sel.selectedIndex].text;
	  document.getElementById('j1').innerHTML = x2;
	  document.getElementById('j2').innerHTML = x3
	  document.getElementById('j3').innerHTML = x5
	  document.getElementById('j4').innerHTML = x6
	  document.getElementById('j5').innerHTML = x4
	  document.getElementById('j6').innerHTML = x10
	  document.getElementById('j7').innerHTML = x16
	  document.getElementById('j8').innerHTML = x11
	  document.getElementById('j9').innerHTML = x12
	  document.getElementById('j10').innerHTML = x13
	  document.getElementById('j11').innerHTML = x14
	  document.getElementById('j12').innerHTML = x15
	  document.getElementById('j13').innerHTML = x9
	  document.getElementById('j15').innerHTML = x1
	  
  }
}
</script>
<script>
// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
	
	validateForm();
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}


</script>