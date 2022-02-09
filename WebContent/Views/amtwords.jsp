<%@ page import="Utils.Number_Word" %>
<%
try{
String country=request.getParameter("val");
if(country != ""){
String words = Number_Word.convert(Integer.parseInt(country));
System.out.print(words+" jiko");
out.print(words+" RUPEES ONLY");
}else{
	out.print("No Amount entered");
}
}
catch(Exception e){
	out.print("Please enter a valid amount");
}
 %>