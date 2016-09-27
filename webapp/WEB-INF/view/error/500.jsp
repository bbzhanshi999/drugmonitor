<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<%@ include file="/WEB-INF/view/include/head.jsp"%>
<html>
<head>
	<title>错误页</title>
	<script type="text/javascript">
		$(document).ready(function(){
			$.messager.alert('错误信息','${error}','error',function(){
				window.location.href='${ctx}';
			});
		})
	</script>
</head>
<body>
</body>