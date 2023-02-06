<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        console.log('Hello javascript in html script');
    </script>
    
</head>
<body>
    <jsp:include page="top_menu.jsp"></jsp:include>
    
    <form action="searchList.do" method="get" id="search">
	    <select name="searchKey" id="select">
	        <option value="">--검색--</option>
	        <option value="name">title</option>
	        <option value="content">content</option>
	        <option value="author">author</option>
	    </select>
        <input type="text" name="searchWord" id="searchWord" value="" placeholder="검색어를 입력하세요">
        <input type="submit" value="검색">
        <br>
    </form>
    

    <form action="searchList.do" method="get" id="test_form">
        <table class="table table-dark table-striped">
            <thead>
              <tr>
                <th> NUM </th> <th> TITLE </th> <th> CONTENT </th> <th> AUTHOR </th>
              </tr>
            </thead>
            <tbody id="board_list">
            	<c:forEach var="vo" items="${vos}"> <!--  돌아가면서 controller 에서 던져준 vos 를 받을 것 이다. -->
            		
            		<tr>
            		<td> <a href="selectOne.do?num=${vo.num}"> ${vo.num}</a> </td> 
            		<td> ${vo.title} </td> 
            		<td> ${vo.content} </td> 
            		<td> ${vo.author} </td> 
            		</tr>
            		
            	</c:forEach>
            </tbody>
       </table>
    </form>
</body>
</html>

<!--  https://tomcat.apache.org/download-taglibs.cgi 에서 아래 네 개 다 다운받아야 한다.

    회원 목록
    폼태그 (검색용)
    테이블 태그
    
-->