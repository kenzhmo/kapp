<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <!-- <script type="text/javascript" src="/webtestwar2/js/angular.min.js" ></script>-->
    <script type="text/javascript" src="<c:url value="/js/jquery-3.1.1.min.js" />" ></script>
    <script>
    var i=0;
    $(document).ready(function(){
    	//get all users
    	  $("#submit").click(function(){
    	    $.ajax({
    	    	url:"/webtestwar2/rest/display/getallusers",
    	    	type:"get",
    	    	dataType:"json"
    	    	}).done(function(json){
    	    		//var jsonStr = JSON.stringify(json);
    	    		//$("#hint").html(jsonStr);
    	    		if (json.length > 0 ) {
    	    			$("#hint").html("<ul id='ol'></ol>");
    	    			for (var i=0; i<json.length;i++){
    	    				$("#ol").append("<li>Name: "+json[i].userName+"</li>");
    	    			}
    	    		} else {
    	    			$("#hint").html("Empty User List!");
    	    		}
    	    		}).fail(function(xhr, status, err){
    	    			alert("problem occurs!");
    	    			console.log("error is [" + err + "]");
    	    			console.log("status is [" + status + "]");
    	    		});
    	  });
    	
    	//get specific user
    	  $("#getUser").click(function(){
    		  var userIdVal = $("#userId").val();
      	    $.ajax({
      	    	url:"/webtestwar2/rest/display/getuser",
      	    	data:{userIdJSONStr:"{'userId':" + userIdVal + "}"},
      	    	type:"get",
      	    	dataType:"json"
      	    	}).done(function(json){
      	    		//var jsonStr = JSON.stringify(json);
      	    		//$("#hint").html(jsonStr);
      	    		if (json != null ) {
      	    			$("#hint").html("<ul id='ol'></ol>");
						$("#ol").append("<li>Name: "+json.userName+"</li>");

      	    		} else {
      	    			$("#hint").html("Invalid User ID!");
      	    		}
      	    		}).fail(function(xhr, status, err){
      	    			alert("problem occurs!");
      	    			console.log("error is [" + err + "]");
      	    			console.log("status is [" + status + "]");
      	    		});
      	  });
    	});
         
</script>
</head>
<body>
    <p>demo.jsp in com.kapp.jsp</p>
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
    
    <label>Demo starts here</label>    
    <input id="userId" name="userId" type="text"/>
	<input id="submit" class="sumbit" type="button" value="Get All Users" />
	<input id="getUser" class="sumbit" type="button" value="Get Specific User" />
	<div id="hint">New Value will be placed here 1</div>
	<!--<p>Angular JS demo starts here</p>
	
	 <div>
   <label>Name:</label>
   <input type="text" ng-model="yourName" placeholder="Enter a name here">
   <h1>Hello {{yourName}}!</h1>
 </div>-->
	
</body>
</html>