<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
//javascript-код голосования из примера
function assertFact(factType, baseDir, fileName) {
	var req = new XMLHttpRequest();
	
	req.onreadystatechange = function() {  
		if (req.readyState == 4) { 
            // complete

			if(req.status == 200) { 
				alert("response: "+req.responseText);
			}
		}
	}

	req.open('POST', '/rest/assert/activity/${uaction.getActivity().getRefId()}', true);
	req.send('{"class":"' + factType + '","baseDir":"' + baseDir + '","fileName":"' + fileName + '"}');
}

</script>
</head>
<body>
	<h1>Build script candidates:</h1>
	
	<ul>
		<c:forEach items="${uaction.buildArtifacts}" var="b">
			<li> <a href="build">${b.getFileName()}</a><br>
		</c:forEach>
	</ul>
	
	<h1>Run executable candidates:</h1>
	
	<ul>
		<c:forEach items="${uaction.execArtifacts}" var="b">
			<li> <a href="run">${b.getFileName()}</a><br>
		</c:forEach>
	</ul>
	<hr>
	<a href="javascript:assertFact('defaultpkg.BuildFile', '/home/andrei/OpenShift/datadir/tmp_2fdf6d85-e99c-4ab5-93a4-4e3e429feab9/3aed16f3-32ea-4a59-af85-16fe6d05d183', 'chordest-master/chordest/pom.xml')">My link</a>
</body>
</html>