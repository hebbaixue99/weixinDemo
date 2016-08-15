<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String url="https://api.weixin.qq.com/cgi-bin/";
//getcallbackip?
String access_token="Om4MIMccfB_2AmJGlsuGUMfSLQSNqV0xSaaVTNvg71C8NMKrxE2zZKslWVRrRqOXWt5V3rvi3mPI_sdlzbiKfnfyILOevawLqZ3Z96XFL_TGNpvIzoNwkBhs_tcY0KZ-FVNiAGANDV";
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String ps=request.getParameter("ps");
if (ps==null) ps = "getcallbackip";
response.sendRedirect(url+ps+"?access_token="+access_token);  
%>
 
