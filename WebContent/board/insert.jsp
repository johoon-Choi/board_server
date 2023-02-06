<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
     </script>
<body>
    <jsp:include page="top_menu.jsp"></jsp:include>
    <hr>
    <h4 id="h2"> 글 작성 </h4>
    <form action="insertOK.do" method="post" id="">
        <table id="t1">
            <tbody>
                <tr>
                    <th> title </th> <th> <input type="text" name="title" id="title" value="" placeholder="title"> </th>
                </tr>
                <tr>
                    <th> content </th> <th> <input type="text" name="content" id="content" value="" placeholder="content"> </th>
                </tr>
                <tr>
                    <th> author </th> <th> <input type="text" name="author" id="author" value="" placeholder="author"> </th>
                </tr>
            </tbody>

            <tfoot>
                <td> <input type="submit" value="작성 완료"> </td>
            </tfoot>
        </table>
    </form>

</body>
</html>

<!--

    회원 가입
    폼태그
    
-->