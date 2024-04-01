<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mylib.tld" prefix="t" %>
<html>
<body>
    <h2>Hello World!</h2>
    <t:mytag></t:mytag>


    <br/>
    <h2>this is my random number within the range of 1 -100 <h2/>
    <t:randomNumber min="1" max="100" />

</body>
</html>
