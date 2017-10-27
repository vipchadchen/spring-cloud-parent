<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.net.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
<style type="text/css">
	input[type="text"]{
		width:400px;
		border: 1px solid #ccc;
	    padding: 2px;
	    font-size: 1.2em;
	    color: #444;
	}
</style>
<%
	String localIp = "127.0.0.1";
	Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
	InetAddress ip = null;
	while (allNetInterfaces.hasMoreElements()){
		NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
		Enumeration addresses = netInterface.getInetAddresses();
		while (addresses.hasMoreElements()){
			ip = (InetAddress) addresses.nextElement();
			if (ip != null && ip instanceof Inet4Address){
				if(ip.getHostAddress().startsWith("10")){
					localIp = ip.getHostAddress();
					break;
				}
			} 
		}
		if(!localIp.startsWith("127")){
			break;
		}
	}
%>
<style type="text/css">  
* {  
    font-size:18px;  
    margin:0;  
    padding:5px;   
}   
fieldset {  
    padding:10px;  
    margin:10px;  
    width:600px;  
    min-height:150px;
    color:#333;   
    border:#06c dashed 1px;  
}   
legend {  
    color:#06c;  
    font-weight:800;   
    background:#fff;  
} 
</style> 
</head>
<body>
<br>
<center>
你好：你的IP是 <%=localIp %>
</center>

</body>
</html>