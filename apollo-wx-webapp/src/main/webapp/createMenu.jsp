<%@page pageEncoding="GB18030" contentType="text/html; charset=utf-8" trimDirectiveWhitespaces="true"%>
<%@page import="java.util.*" %>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="com.ncs.web.wx.menu.*" %>
<%@page import="java.net.URLEncoder" %>
<%@page import="com.ncs.web.wx.service.WxService" %>
<%
ApplicationContext applicationContext = WebApplicationContextUtils
        .getRequiredWebApplicationContext(getServletConfig().getServletContext());
WxService wxService = applicationContext.getBean("apollo-wx-service", WxService.class);

SingleButton button = new SingleButton("查看菜单");
String redirecturl4 = "http://oatest.newcensoft.com.cn/weixin/index.html?targetPage=tzgg";
String encode4 = URLEncoder.encode(redirecturl4, "utf-8");
ViewButton vb = new ViewButton("通知公告", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb457a723ee95f18f&redirect_uri="+encode4+"&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect");
String redirecturl5 = "http://oatest.newcensoft.com.cn/weixin/index.html?targetPage=zzwj";
String encode5 = URLEncoder.encode(redirecturl5, "utf-8");
ViewButton vb4 = new ViewButton("资质文件", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb457a723ee95f18f&redirect_uri="+encode5+"&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect");
List<SingleButton> list = new ArrayList<SingleButton>();
list.add(vb);
list.add(vb4);
button.setSub_button(list);

SingleButton button2 = new SingleButton("门户菜单");
String redirecturl = "http://oatest.newcensoft.com.cn/weixin/index.html";
String encode = URLEncoder.encode(redirecturl, "utf-8");
ViewButton vb1 = new ViewButton("门户网站", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb457a723ee95f18f&redirect_uri="+encode+"&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect");

String redirecturl2 = "http://oatest.newcensoft.com.cn/weixin/index.html?targetPage=gzlb";
String encode2 = URLEncoder.encode(redirecturl, "utf-8");
ViewButton vb2 = new ViewButton("工作列表", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb457a723ee95f18f&redirect_uri="+encode2+"&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect");

String redirecturl3 = "http://oatest.newcensoft.com.cn/weixin/index.html?targetPage=qjsq";
String encode3 = URLEncoder.encode(redirecturl, "utf-8");
ViewButton vb3 = new ViewButton("请假申请", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb457a723ee95f18f&redirect_uri="+encode3+"&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect");
List<SingleButton> list2 = new ArrayList<SingleButton>();
//PicPhotoOrAlbumButton photoButton = new PicPhotoOrAlbumButton("传图按钮1", "photo1");
//LocationSelectButton locationButton = new LocationSelectButton("地址选择", "address");
//list2.add(photoButton);
//list2.add(locationButton);
list2.add(vb1);
list2.add(vb2);
list2.add(vb3);
button2.setSub_button(list2);
wxService.createMenu(new SingleButton[]{button, button2});
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Menu</title>
</head>
<body>
  <h2>Create Menu</h2>
</body>
</html>
