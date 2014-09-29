<%@page import="java.util.LinkedList"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession.QResult"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFinalStatus"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestRuntimeStatus"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifactList"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl.UserActionRef"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.Alias"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifact"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.userinfo.UserInfo"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.List"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.UserAction"%>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatusRelatedFact"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Request status</title>
</head>

<%!
public String getStatusKind(Object s){
    if (s instanceof RequestRuntimeStatus) return "Runtime status";
    else if (s instanceof RequestFinalStatus) return "Completion status";
    else return s.getClass().getCanonicalName();
}

public String getActionDescription(Object ua){
    switch (ua.getClass().getCanonicalName()){
    case "defaultpkg.UserActionSelectBuildOrRun":
        return "Select build script or executable file";
    case "defaultpkg.UserActionSelectRunFormat":
        return "Select run command format";
    case "defaultpkg.UserActionSelectEncoding":
        return "Select sources encoding";
    default:
        return "Unknown action";
    }
}
%>
<body bgcolor=white>

    <h1>Request status:</h1>
    
    <table border ="1" width="100%">
        <tr>
            <th>status type</th>
            <th>status value</th>
        </tr>

<%
        List<QResult> status = (List<QResult>)request.getAttribute("status");
        for (QResult s : status) {
%> 
            <tr>
                <td> <% out.print(getStatusKind(s.mainStatus)); %> </td>
                <td> <% out.print(s.mainStatus.getMessage()); %> </td>
            </tr>
<%
        }
%>
    </table>
    
    <br>
    
    <h1>Available actions:</h1>
    <ul>
    
    <%
        List<RequestStatusRelatedFact> extras = (List<RequestStatusRelatedFact>)request.getAttribute("extras");
        for (RequestStatusRelatedFact i : extras) {
            if (i instanceof Alias && ((Alias)i).getRefObject() instanceof UserActionRef){
                UserAction ua = ((UserActionRef)((Alias)i).getRefObject()).getRefObject();

                String description = getActionDescription(ua);

                String url = "/rest/useraction/" + ua.getClass().getSimpleName() + "/" + 
                    ua.getRefId() + "?r=" + i.getRstatus().getRequest().getRefId();
                
                %>
                    <li><a href="<%=url%>"><%=description%></a> - (dbg: <%=ua.getClass().getCanonicalName()%>)
                <%
                
            }
        }
    %>
    
    </ul>
    
    <br>
    
    <h1>Additional information:</h1>
    <table border ="1" width="100%">
        <tr>
            <th>Timestamp</th>
            <th>Title</th>
            <th>Description</th>
        </tr>
    
<%
        for (RequestStatusRelatedFact i : extras) {
            if (i instanceof Alias && ((Alias)i).getRefObject() instanceof UserInfo){
                UserInfo usrInfo = (UserInfo)((Alias)i).getRefObject();
                String description = usrInfo.getMessage().toString();
                String title = usrInfo.getName();
                List<FileArtifact> flist = null;
                Object msg = usrInfo.getMessage();
                
                if (msg instanceof FileArtifact){
                    FileArtifact file = (FileArtifact)usrInfo.getMessage();
                    flist = new LinkedList<FileArtifact>();
                    flist.add(file);
                }
                
                if (msg instanceof FileArtifactList){
                    FileArtifactList fl = (FileArtifactList)usrInfo.getMessage();
                    flist = fl.list();
                }
%>
                <tr>
                    <td><%=usrInfo.getDate()%></td>
                    <td><%=title%></td>
<% 
                if (flist == null) {
%>
                    <td><%=description%></td>
<%
                } else {
                    for (FileArtifact f : flist){
                        String _url = "/rest/files?file=" + URLEncoder.encode(f.getAbsolutePath());
                        String _description = f.getFileName();
%>
                        <td><a href="<%=_url%>"><%=_description%></a><br></td>
<%
                    }
                }
%>
                </tr>
<%
            }
        }
%>
    
    </table>
</body>
</html>
