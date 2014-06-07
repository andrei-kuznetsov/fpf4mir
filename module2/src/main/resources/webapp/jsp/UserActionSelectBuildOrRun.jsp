<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function assertFact(factType, baseDir, fileName) {
	var req = new XMLHttpRequest();
	
	req.onreadystatechange = function() {  
		if (req.readyState == 4) { 
            // complete

			if (req.status == 304 /*see other*/){
				//window.location.href = ""
				alert("redirect");
			} else if (req.status != 200) { 
				alert(req.responseText);
			}
		}
	}

	req.open('POST', '/rest/useraction/${uaction.getClass().getSimpleName()}/${uaction.getRefId()}/handled', true);
	req.send('{"class":"' + factType + '","baseDir":"' + baseDir + '","fileName":"' + fileName + '"}');
}

</script>
</head>
<body>
	<h1>Build script candidates:</h1>
	
	<ul>
		<c:forEach items="${uaction.buildArtifacts}" var="b">
			<li>
			<a href="javascript:assertFact('defaultpkg.BuildFile', '${b.getBaseDir().replace('\\','//')}', '${b.getFileName().replace('\\','//')}')">${b.fileName}</a> 
			<br>
		</c:forEach>
	</ul>
	
	<h1>Run executable candidates:</h1>
	
	<ul>
		<c:forEach items="${uaction.execArtifacts}" var="b">
			<li> <a href="run">${b.getFileName()}</a><br>
		</c:forEach>
	</ul>
</body>
</html>