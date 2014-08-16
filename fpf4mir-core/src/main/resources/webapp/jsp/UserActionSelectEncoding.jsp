<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function assertFact(encoding) {
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
	req.send('{"class":"defaultpkg.UsrUseEncoding", "encoding":"' + encoding + '"}');
}

</script>
</head>
<body>
	<h1>Please select sources encoding:</h1>
	
	<ul>
		<li><a href="javascript:assertFact('UTF-8')">UTF-8</a> 
		<br>
		<li><a href="javascript:assertFact('Windows-1251')">Windows-1251 (windows cyrillic)</a> 
		<br>
		<li>
		<input id="encoding"> <a href="javascript:assertFact(document.getElementById('encoding').value)">ok</a>
	</ul>
	
</body>
</html>