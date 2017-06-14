<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Missing Bits</title>
</head>
<body>
	The next clue is: hsvtzfcxpd.ww
	<br>
	<h4>You can test the encryption here:</h4>
	<form action="bykffkymvb.jsp" method=post>
		<input type="text" name="text" placeholder="Test encryption">
		<input type="submit" value="Submit">
	</form>
	<%
		String g = request.getParameter("text");
		if (g != null) {
			int x = 0;
			String str = "";
			for (int i = 0; i < g.length(); i++) {
				if (Character.isAlphabetic(g.charAt(i))) {
					char h = (char) (g.charAt(i) - 'a');
					h = (char) ((h + x) % 26);
					str += (char) (h + 'a');
					x++;
				} else {
					str += g.charAt(i);
				}
			}
			out.println(str);
		}
	%>
</body>
</html>