<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p>greeting.jsp inside WebTestWAR2,webapp, WEB-INF</p>
    <p>${message}</p>
    <table border="1">
        <tbody>  
            <tr>  
                <th>User ID</th>  
                <th>User Name</th>  
                <th>PR Flag</th>  
            </tr>  
            <c:if test="${!empty userList }">  
                <c:forEach items="${userList }" var="user">  
                    <tr>  
                        <td>${user.userId }</td>
                        <td>${user.userName }</td>  
                        <td>${user.prFlag }</td>   
                    </tr>               
                </c:forEach>  
            </c:if>  
        </tbody>  
    </table>
</body>
</html>