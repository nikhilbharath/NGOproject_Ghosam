<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

* {
  box-sizing: border-box;
  font-family: Arial, Helvetica, sans-serif;
}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 14px;

}


</style>
<script>
$("<iframe>")  {                       // create a new iframe element
.hide()                               // make it invisible
.attr("src", "/FormController")       // point the iframe to the page you want to print
.appendTo("body");                    // add iframe to the DOM to cause it to load the page
{

$(document).ready(function () {
//    window.print();
	 var divContents = document.getElementById("GFG").innerHTML; 
     var a = window.open('', '', 'height=2000, width=2000'); 
     a.document.write('<html>'); 
     a.document.write('<body >'); 
     a.document.write(divContents); 
     a.document.write('</body></html>'); 
     a.document.close(); 
     a.print(); 
});
}
</script>
</head>
<body >


  <a href="/GhoSam/Views/BookingForm.jsp" style="float:left">Go Back</a>
  <input type="button" style="float:right" value="Print" onClick="window.print()">
  <div id="GFG">
  <table align="center">
  <tr>
    <th></th>
  </tr>
  <tr>
    <td align="center">MUTT's COPY</td>
  </tr>
  <tr>
    <td align="center">SRI HARI VAYU GURU</td>
  </tr>
  <tr>
    <td align="center">${Obj.trustID.trustName}</td>
  </tr>
  <tr>
    <td align="center">${Obj.trustID.trust_AddressLine1},${Obj.trustID.trust_AddressLine2}</td>
  </tr>
  <tr>
    <td align="center">${Obj.trustID.trust_City}-${Obj.trustID.trust_Pin}</td>
  </tr>
  <tr>
    <td align="center">${Obj.trustID.trust_Contact} / ${Obj.trustID.trust_Email}</td>
  </tr>
  
</table>

  <div style="float:left"> SNO : ${Obj.receiptno}</div>
  <div style="float:right"> DATE : ${Obj.poojaBookingDate}</div><br>
  <div style="float:left"> NAME : ${Obj.donar_Name}</div><br><br>
  
   <div style="float:left"> ADDRESS </div><br>
   <div style="float:left"> ${Obj.donar_AddressLine1}</div><br>
   <div style="float:left"> ${Obj.donar_AddressLine2}</div><br><br>
   <div style="float:left"> CONTACT : ${Obj.contact_No}</div><br>
   <div style="float:left"> SCHEME : ${Obj.scheme.poojaScheme}</div><div style="float:right"> PAYMENT DATE : ${Obj.paymentDate}</div><br>
   <div style="float:left"> OTHER PARTICULAR : ${Obj.gothram} / ${Obj.natchatram.natchatramName} / ${Obj.raasi.raasiName}</div><br>
   <div style="float:left"> PAN : ${Obj.donar_PAN}</div><br>
   <div style="float:left"> MODE OF PAYMENT : ${Obj.payMode.paymentMode}</div><br><br>
   
   <div style="float:left"> AMOUNT : ${Obj.amount}</div><br>
   <div style="float:left"> AMOUNT IN WORDS : ${Obj.amountwords}</div><br><br>
   
    <div style="float:right"><hr color="black" width="100%">
    Receiver's Signature</div>
    <div></div>
   


<div class="footer">
  <p>Note: Donations are Exempted Under Sec 80G Income Tax Act 1961</p>
  <p>AAITS7919Q</p>
</div>
<hr color="black" width="100%">

<div class="topnav">
<table align="center">
  <tr>
    <th></th>
  </tr>
  <tr>
    <td align="center">DONOR's COPY</td>
  </tr>
  <tr>
    <td align="center">SRI HARI VAYU GURU</td>
  </tr>
  <tr>
    <td align="center">${Obj.trustID.trustName}</td>
  </tr>
  <tr>
    <td align="center">${Obj.trustID.trust_AddressLine1},${Obj.trustID.trust_AddressLine2}</td>
  </tr>
  <tr>
    <td align="center">${Obj.trustID.trust_City}-${Obj.trustID.trust_Pin}</td>
  </tr>
  <tr>
    <td align="center">${Obj.trustID.trust_Contact} / ${Obj.trustID.trust_Email}</td>
  </tr>
  
</table>
  
</div>

<div class="content">
  <div style="float:left"> SNO :  ${Obj.receiptno}</div>
  <div style="float:right"> DATE : ${Obj.poojaBookingDate}</div><br>
  <div style="float:left"> NAME : ${Obj.donar_Name}</div><br><br>
  
   <div style="float:left"> ADDRESS </div><br>
   <div style="float:left"> ${Obj.donar_AddressLine1}</div><br>
   <div style="float:left"> ${Obj.donar_AddressLine2}</div><br><br>
   <div style="float:left"> CONTACT : ${Obj.contact_No}</div><br>
   <div style="float:left"> SCHEME : ${Obj.scheme.poojaScheme}</div><div style="float:right"> PAYMENT DATE : ${Obj.paymentDate}</div><br>
   <div style="float:left"> OTHER PARTICULAR : ${Obj.gothram} / ${Obj.natchatram.natchatramName} / ${Obj.raasi.raasiName}</div><br>
   <div style="float:left"> PAN : ${Obj.donar_PAN}</div><br>
   <div style="float:left"> MODE OF PAYMENT : ${Obj.payMode.paymentMode}</div><br><br>
   
   <div style="float:left"> AMOUNT : ${Obj.amount}</div><br>
   <div style="float:left"> AMOUNT IN WORDS : ${Obj.amountwords}</div><br><br>
   
    <div style="float:right"><hr color="black" width="100%">
    Receiver's Signature</div>
    <div></div>
   
</div>

<div class="footer">
  <p>Note: Donations are Exempted Under Sec 80G Income Tax Act 1961</p>
  <p>AAITS7919Q</p>
</div>
</div>
</body>
</html>
<script type="text/javascript">

var divContents = document.getElementById("GFG").innerHTML; 
var a = window.open('', '', 'height=2000, width=2000'); 
a.document.write('<html>'); 
a.document.write('<body style="font-size:14px">'); 
a.document.write(divContents); 
a.document.write('</body></html>'); 
a.document.close(); 
a.print(); 

</script>