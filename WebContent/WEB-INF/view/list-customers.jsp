<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRM</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <form:form action="search" method="get">
            <h3>Search Customer</h3>
            <input type="text" name="name">
            <input type="submit" value="Search" class="add-button">
        </form:form>

        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button">

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <c:forEach var="customer" items="${customers}">

                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${customer.id}"></c:param>
                </c:url>

                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${customer.id}"></c:param>
                </c:url>

                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

</body>
</html>