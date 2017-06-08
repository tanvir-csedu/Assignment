<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Task Management</title>
<script type="text/javascript">
	function editThisRow(element, id){
		var currentRowElements = element.parentNode.parentNode.childNodes;
		var numOfElement = 0;
		var elementNameMap = ['id', 'taskName', 'taskDetails'];
		document.getElementsByName(elementNameMap[numOfElement++])[0].value = id;
        for(var i=0;i<currentRowElements.length;i++){
            if(currentRowElements[i].nodeName.indexOf("TD")>=0){
            	//alert(elementNameMap[numOfElement]+"; "+currentRowElements[i].innerHTML);
            	document.getElementsByName(elementNameMap[numOfElement++])[0].value = currentRowElements[i].innerHTML;
            	if(numOfElement>=3){
            		break;
            	}
            }        	
        }
	}
	
	function isVerified(){
		var f = document.forms[0];
		
    	if(f.taskName.value==null || f.taskName.value==''){
          alert("Please enter a valid task Name");
          return false;
        }
    	if(f.taskDetails.value==null || f.taskDetails.value==''){
          alert("Please enter a valid task details");
          return false;
        }
    	return true;
	}
</script>
</head>
<body>
<br><br><br>
<form:form action="AddUpdateTask" method="POST" commandName="task" onsubmit="return isVerified();">
	<table>
		<tr>
			<td>Task name</td>
			<td><input type="text" name="taskName" /></td>
		</tr>
		<tr>
			<td>Task Details</td>
			<td><input type="text" name="taskDetails" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Add/Save" />
				<input type="hidden" name="id" value="-1">
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<thread>
		<th>Task name</th>
		<th>Task Details</th>
		<th>Edit</th>
		<th>Delete</th>
	</thread>
	<tbody>	
		<c:forEach items="${taskList}" var="taskObj">
			<tr>
				<td>${taskObj.taskName}</td>
				<td>${taskObj.taskDetails}</td>
				<td><a href="javascript:;" onclick="editThisRow(this, '${taskObj.id}')">Edit</a></td>
				<td><a onclick="return confirm('Are you sure?');" href="DeleteTask/${taskObj.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>