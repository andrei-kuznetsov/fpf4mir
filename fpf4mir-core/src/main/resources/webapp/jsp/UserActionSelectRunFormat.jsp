<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function assertFact(factType) {
	var req = new XMLHttpRequest();
	
	req.onreadystatechange = function() {  
		if (req.readyState == 4) { 
            // complete

			if (req.status == 304 /*see other*/){
				//window.location.href = "/rest/status/request/${uaction.getActivity().getRequest().getRefId()}"
				alert("redirect");
			} else if (req.status == 200) {
				window.location.href = "/rest/status/request/${r}";
			} else { 
				alert(req.responseText);
			} 
		}
	}

	req.open('POST', '/rest/useraction/${uaction.getClass().getSimpleName()}/${uaction.getRefId()}/handled?r=${r}', true);
	req.send('{"class":"' + factType + '"}');
}

</script>
</head>
<body>
	<h1>Available run command formats:</h1>
	
	<ul>
		<li><a href="javascript:assertFact('defaultpkg.RunFormat_Mirex_Aud_ChEst')">MIREX: Audio chord estimation task:</a> exec {inFileList} {scratch} {outDir} 
		<br>
		<li><a href="javascript:assertFact('defaultpkg.RunFormat_Rest')">Free-form REST:</a> /a1/a2/a3/a4 &rarr; exec {a1} {a2} {a3} {a4} 
		<br>
	</ul>
	
</body>
</html>