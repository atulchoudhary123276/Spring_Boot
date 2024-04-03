<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL Formatting Tags</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        h2 {
            color: #666;
        }
        pre {
            background-color: #eee;
            padding: 10px;
            border-radius: 5px;
        }
        strong {
            color: #009;
        }
    </style>
</head>
<body>
    <h1>JSTL Formatting Tags - for internationalization like currency</h1>
    <h2>MY number:${param.input}</h2>
    Formatting my Number:
    <br><br>
    IN FRENCH:
    <fmt:setLocale value="fr"/>
    <pre>
        <b>My Num:<fmt:formatNumber type="number" value="${param.input}"/></b>
        ---currency type
        Default pattern:-----
        <b><fmt:formatNumber type="currency" value="${param.input}"/></b>
        Using Pattern:----"00,0,00.000"
        <b><fmt:formatNumber type="currency" value="${param.input}" pattern="00,0,00.000"/></b>
    </pre>

    <br><br>
    IN USA:
    <fmt:setLocale value="en_US"/>
    <pre>
        <b>My Num:<fmt:formatNumber type="number" value="${param.input}"/></b>
        ---currency type
        Default pattern:-----
        <b><fmt:formatNumber type="currency" value="${param.input}"/></b>
        Using Pattern:----"00,0,00.000"
        <b><fmt:formatNumber type="currency" value="${param.input}" pattern="00,0,00.000"/></b>
    </pre>

    <h2>MY Date:${param.inputDate}</h2>
    Formatting my Date:
    <h2>from form</h2>
    <c:set var="inputDateStr" value="${param.inputDate}" />
    <fmt:parseDate var="today" value="${inputDateStr}" pattern="yyyy-MM-dd" />
    <p>Time: <strong><fmt:formatDate type="time" value="${today}" /></strong></p>
    <p>Date: <strong><fmt:formatDate type="date" value="${today}"  /></strong></p>
    <p>Date & Time: <strong><fmt:formatDate type="both" value="${today}" /></strong></p>

    <h2>from Current Date</h2>
    <c:set var="now" value="<%=new java.util.Date()%>"/>
    <h3>Current Date: <c:out value="${now}"/></h3>
    <p>Time: <strong><fmt:formatDate type="time" value="${now}" /></strong></p>
        <p>Date: <strong><fmt:formatDate type="date" value="${now}"  /></strong></p>
            <p>Date & Time: <strong><fmt:formatDate type="both" value="${now}" /></strong></p>


    With Pattern ---"yyyy-MM-dd"
    <p>Date: <strong><fmt:formatDate type="date" value="${now}" pattern="yyyy-MM-dd"/></strong></p>

</body>
</html>
