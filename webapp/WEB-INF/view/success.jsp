<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <form action="${ctx}/authTest">
        <input type="text" name="fuck"/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
