<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactList"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.UserActionRef"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Alias"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.UserInfo"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.List"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.UserAction"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestStatusRelatedFact"%>
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
			if (i instanceof Alias && ((Alias)i).getRefObject() instanceof UserActionRef){
				UserAction ua = ((UserActionRef)((Alias)i).getRefObject()).getRefObject();
				String url = null;
				String description = null;
				
				switch (ua.getClass().getCanonicalName()){
				case "defaultpkg.UserActionSelectBuildOrRun":
					url = "/rest/useraction/UserActionSelectBuildOrRun/" + ua.getRefId();
					description = "Select build script or executable file";
					break;
				case "defaultpkg.UserActionSelectRunFormat":
					url = "/rest/useraction/UserActionSelectRunFormat/" + ua.getRefId();
					description = "Select run command format";
					break;
				case "defaultpkg.UserActionSelectEncoding":
					url = "/rest/useraction/UserActionSelectEncoding/" + ua.getRefId();
					description = "Select sources encoding";
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
	
	
	<h1>Additional information:</h1>
	<table border ="1">
	
	<%
		for (RequestStatusRelatedFact i : extras) {
			if (i instanceof Alias && ((Alias)i).getRefObject() instanceof UserInfo){
				UserInfo usrInfo = (UserInfo)((Alias)i).getRefObject();
				String url = null;
				String description = usrInfo.getMessage().toString();
				String title = usrInfo.getName();
				
				if (usrInfo.getMessage() instanceof FileArtifact){
					FileArtifact file = (FileArtifact)usrInfo.getMessage();
					
					// TODO: /rest/userinfo/refId
					url = "/rest/files?file=" + URLEncoder.encode(file.getAbsolutePath());
					description = file.getFileName();

					%>
					<tr>
						<td><%=usrInfo.getDate()%></td>
						<td><%=title%></td>
						<td><a href="<%=url%>"><%=description%></a></td>
					</tr>
					<%
				} else if (usrInfo.getMessage() instanceof FileArtifactList){
					FileArtifactList flist = (FileArtifactList)usrInfo.getMessage();

					%>
					<tr>
						<td><%=usrInfo.getDate()%></td>
						<td><%=title%></td>
						<td>
					<%
					
					for (FileArtifact f : flist.list()){
						String _url = "/rest/files?file=" + URLEncoder.encode(f.getAbsolutePath());
						String _description = f.getFileName();
						%>
							<a href="<%=_url%>"><%=_description%></a><br>
						<%
					}

					%>
						</td></tr>
					<%
				} else {
					%>
					<tr>
						<td><%=usrInfo.getDate()%></td>
						<td><%=title%></td>
						<td><%=description%></td>
					</tr>
					<%
				}
			}
		}
	%>
	
	</table>
</body>
</html>
