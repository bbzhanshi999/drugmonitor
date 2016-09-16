<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>message</title>
</head>
<body>
    <shiro:hasPermission name="user:eat">
        权限验证成功 ${permissions}
    </shiro:hasPermission>
    <shiro:hasRole name="aaa">
        有角色aaa
    </shiro:hasRole>
    <shiro:hasRole name="ddd">
        有角色ddd
    </shiro:hasRole>
</body>
</html>
