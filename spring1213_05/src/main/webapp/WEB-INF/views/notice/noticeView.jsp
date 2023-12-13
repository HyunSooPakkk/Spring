<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글보기</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		   *{margin:0; padding:0;}
		   div{width:1000px; margin:30px auto; text-align: center;}
		   h1{margin-bottom:30px; }
		   table{width:100%;}
		   table,th,td{border:1px solid black; border-collapse: collapse;
		   font-size: 16px; }
		   th{height:40px; }
		   img{width:80%;}
		   button{width:150px; height:40px; margin-top:30px; }
		</style>
		<script>
		$(function(){
	    	$("#insert_fbtn").click(function(){
	    		//alert($("#btitle").val());
	    		alert("게시글을 수정합니다.");
	    		b_frm.submit();
	    	});
	    });
		
		$(function(){
	    	$("#delete_fbtn").click(function(){
	    		//alert($("#btitle").val());
	    		alert("게시글을 삭제합니다.");
	    		b_frm.submit();
	    	});
	    });
		
		$(function(){
	    	$("#list_fbtn").click(function(){
	    		//alert($("#btitle").val());
	    		alert("게시글 목록으로 돌아갑니다.");
	    		b_frm.submit();
	    	});
	    });
		</script>
	</head>
	<body>
	  
	  <div>
	  <form name="b_frm" method="get" action="notice/noticeList" enctype="multipart/form-data">
	   <h1>회원정보보기</h1>
		   <table>
		     <colgroup>
		       <col width="20%">
		       <col width="80%">
		     </colgroup>
		     <tr>
		       <th>번호</th>
		       <td></td>
		     </tr>
		     <tr>
		       <th>작성자</th>
		       <td></td>
		     </tr>
		     <tr>
		       <th>날짜</th>
		       <td></td>
		     </tr>
		     <tr>
		       <th>제목</th>
		       <td></td>
		     </tr>
		     <tr>
		       <th>내용</th>
		       <td></td>
		     </tr>
		     <tr>
		       <th>이미지</th>
		       <td><img src="upload/"></td>
		     </tr>
		   </table>
		   <a href="noticeInsert"><button type="button" id="insert_fbtn">게시글수정</button></a>
		   <a href="/"><button type="button" id="delete_fbtn">게시글삭제</button></a>
		   <a href="noticeList"><button type="button" id="list_fbtn">게시글리스트</button></a>
	  </div>
	
	</body>
</html>