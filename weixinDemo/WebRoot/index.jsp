<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
//https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx4a82bb9891f2bdc1&secret=4e2003db8e93049f46694f17c7cd3ba2
//{"access_token":"Om4MIMccfB_2AmJGlsuGUMfSLQSNqV0xSaaVTNvg71C8NMKrxE2zZKslWVRrRqOXWt5V3rvi3mPI_sdlzbiKfnfyILOevawLqZ3Z96XFL_TGNpvIzoNwkBhs_tcY0KZ-FVNiAGANDV","expires_in":7200}
String appID = "wx4a82bb9891f2bdc1";
String appsecret="4e2003db8e93049f46694f17c7cd3ba2";
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  System.out.println("开始签名校验");
  String signature = request.getParameter("signature");
  String timestamp = request.getParameter("timestamp");
  String nonce = request.getParameter("nonce");
  String echostr = request.getParameter("echostr");
  response.getWriter().println(echostr);
%>
 
