<%@page import="java.net.URL"%>
<%@page import="java.util.List"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.UserAction"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestStatusRelatedFact"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.UserActionAlias"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Request status</title>
</head>

<body bgcolor=white>

	<c:forEach items="${status}" var="s">
		<h1>${s.mainStatus.getMessage()}</h1>
	</c:forEach>

	<br />
	
	<h1>Available actions:</h1>
	<table border ="1">
	
	<%
		List<RequestStatusRelatedFact> extras = (List<RequestStatusRelatedFact>)request.getAttribute("extras");
		for (RequestStatusRelatedFact i : extras) {
			if (i instanceof UserActionAlias){
				UserAction ua = ((UserActionAlias)i).getRefObject();
				String url = null;
				String description = null;
				switch (ua.getClass().getCanonicalName()){
				case "defaultpkg.UserActionSelectBuildOrRun":
					url = "/rest/useraction/UserActionSelectBuildOrRun/" + ua.getRefId();
					description = "Select build script or executable file";
					break;
				default:
					url = null;
				}
				
				if (url != null){
					%>
					<tr>
						<td><%=ua.getClass().getCanonicalName()%></td>
						<td><a href="<%=url%>"><%=description%></a></td>
					</tr>
					<%
				} else {
					%>
					<tr>
						<td><%=ua.getClass().getCanonicalName()%></td>
						<td><%=ua.toString()%></td>
					</tr>
					<%
				}
			}
		}
	%>
	
	</table>
</body>
</html>
