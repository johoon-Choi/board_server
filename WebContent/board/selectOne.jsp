<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="member_css.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>=
    <jsp:include page="top_menu.jsp"></jsp:include>
    <form action="#" method="get" id="f1">
        <table id="t1">
            <tbody>
            	<tr>
            		<td> ${vo2.num} </td>
            		<td> ${vo2.title} </td>
            		<td> ${vo2.content} </td>
            		<td> ${vo2.author} </td>
            	</tr>
                
            </tbody>

            <tfoot>
                <td>
                    <a href="index.do" target="_self" id="a_return_home"> [HOME] </a>
                    <a href="update.do?num=${vo2.num}" target="_self" id="a_return_home"> [UPDATE] </a>
                    <a href="delete.do?num=${vo2.num}" target="_self" id="a_return_home"> [DELETE] </a>
                </td>
            </tfoot>
        </table>
    </form>
</body>
</html>

<!--

    회원 정보
    
-->