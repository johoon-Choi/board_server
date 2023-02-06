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
<body>
    <jsp:include page="top_menu.jsp"></jsp:include>
    <hr>
    <h4 id="h2"> 글 삭제 </h4>
    <form action="deleteOK.do" method="get" id="test_form">
        <table id="t1">
            <tbody>
                <tr>
                    <th> num </th> <th> ${param.num}<input type="hidden" name="num" id="num" value="${param.num}" placeholder="NUM"> </th>
                </tr>
            </tbody>

            <tfoot>
                <td> <input type="submit" value="삭제 하기"> </td>
                <td> 
                    <a href="index.do" target="_self" id="a_return_home"> [HOME] </a>
                </td>
            </tfoot>
        </table>
    </form>
</body>
</html>

<!--

    회원 삭제
    폼태그

-->