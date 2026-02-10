<%@ include file="menu.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Product Table</title>
  <style>
    table {
      border-collapse: collapse;
      margin: auto;
      width: 80%;
      background-color: white;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
      margin-top: 20px;
    }

    th, td {
      padding: 14px 20px;
      text-align: center;
      border-bottom: 1px solid #ddd;
    }

    th {
      background: linear-gradient(to bottom, #1abc9c, #16a085);
      color: white;
      cursor: pointer;
      user-select: none;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    tr:nth-child(even) td {
      background-color: #f9f9f9;
    }
  </style>
</head>
<body onload="makeActive('list')">
  <table>
    <thead>
      <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Product Brand</th>
        <th>Product Price</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="product" items="${productList}">
	    <tr>
    	  <td>${product.pid}</td>
    	  <td>${product.name}</td>
    	  <td>${product.brand}</td>
    	  <td>${product.price}</td>
    	</tr>
      </c:forEach>	
    </tbody>
  </table>
</body>
</html>
