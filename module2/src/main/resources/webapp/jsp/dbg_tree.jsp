<!DOCTYPE html>
<%@page import="ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Stack"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- link rel="stylesheet" href="../css/style.css" type="text/css" media="screen, projection">
	<script type="text/javascript" src="../js/jquery-1.4.2.min.js">
	</script>
	<script type="text/javascript" src="../js/scripts.js">
	</script-->
</head>
<body>

	<h1>Debug trace</h1>

	<div id="listContainer">
		<div class="listControl">
			<a id="expandList">Expand All</a> <a id="collapseList">Collapse
				All</a>
		</div>
		
		<br>
		<a href="">debug on</a> <a href="">debug off</a> <a href="">debug step</a>
		
		<ol id="expList">

			<%
				Map<Object, List<Object>> tree = (Map<Object, List<Object>>) request
						.getAttribute("tree");
				List<Object> roots = (List<Object>)request.getAttribute("roots");

				Stack<Iterator<Object>> stack = new Stack<Iterator<Object>>();
				stack.push(roots.iterator());

				while (!stack.isEmpty()) {
					Iterator<Object> it = stack.peek();
					if (it.hasNext()) {
						Object key = it.next();
						out.print("<li>" + key);
						List<Object> lst = tree.get(key);
						if (lst == null) {
							out.println("</li>");
						} else {
							out.println("<ol>");
							stack.push(lst.iterator());
						}
					} else {
						stack.pop();
						if (!stack.isEmpty()) {
							out.println("</ol>");
							out.println("</li>");
						}
					}
				}
			%>
		</ol>
	</div>

</body>
</html>