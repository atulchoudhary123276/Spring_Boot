<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL Core Tags Test</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        p {
            color: #666;
            margin-bottom: 10px;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin-bottom: 5px;
        }
        form {
            margin-top: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin: 0 auto;
        }
        input[type="number"],
        input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>JSTL Core Tags Test</h1>

    <p>
        The games we play:
        <ul>
            <c:forEach items="${list}" var="game">
                <li>${game}</li>
            </c:forEach>
        </ul>
    </p>
    <!-- Setting a variable using c:set -->
    <c:set var="greeting" value="Hello, JSTL!" />

    <!-- Displaying the value of the variable -->
    <p>${greeting}</p>

    <!-- Using c:if for conditional rendering -->
    <c:if test="${not empty greeting}">
        <p>This will be displayed if the greeting is not empty.</p>
    </c:if>

    <!-- Using c:choose and c:when for conditional rendering with multiple branches -->
    <c:choose>
        <c:when test="${empty greeting}">
            <p>This will be displayed if the greeting is empty.</p>
        </c:when>
        <c:otherwise>
            <p>This will be displayed if the greeting is not empty.</p>
        </c:otherwise>
    </c:choose>

    <!-- Using c:forEach for iterating over a collection -->
    <c:set var="employeeList" value="${['John', 'Doe', 'Alice', 'Bob']}" />
    <ul>
        <c:forEach var="employee" items="${employeeList}">
            <li>${employee}</li>
        </c:forEach>
    </ul>

    <!-- Using c:out for escaping and displaying content -->
    <c:set var="htmlContent" value="<b>Important Message</b>" />
    <p>Unescaped Content: ${htmlContent}</p>
    <p>Escaped Content: <c:out value="${htmlContent}" /></p>

    <h1>JSTL Function Tags - for string manipulation </h1>
    <!-- this is url for function tag<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> -->
    <c:set var="name" value="Atul choudhary"></c:set>
    <h3>The value of string is:<c:out value="${name}"> this is default text</c:out></h3>

    <h3>length of string is :<c:out value="${fn:length(name)}"></c:out></h3>
    <h3>To upper case :<c:out value="${fn:toUpperCase(name)}"></c:out></h3>
    <h3>To lower case :<c:out value="${fn:toLowerCase(name)}"></c:out></h3>

    <h1>JSTL Formatting Tags - for internationalization like currency </h1>
    <!-- this is url for function tag<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> -->
    <form action="format.jsp" method="POST">
        Enter Number for format:<input type="number" name="input" placeholder="enter a number for formatting"/>
        <br/>
        <br/>
        Enter Date for formatting:<input type="date" name="inputDate" placeholder="enter a date"/>
        <br/>

        <input type="submit" name="submit" value="Submit"/>

    </form>
</body>
</html>
