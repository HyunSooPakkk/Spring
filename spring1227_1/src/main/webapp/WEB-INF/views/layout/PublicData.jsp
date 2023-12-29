<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공공데이터</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		#main{width:1600px; margin:20px auto; text-align:center;}
		#body{width:1600px; height:700px; margin:20px auto; border:3px solid yellowgreen; text-align:center;}
		table{width: 1400px; margin:0px auto;}
		table,th,td{border: 1px solid yellowgreen; border-collapse: collapse;}
		th{height: 40px;}
		td{height: 35px;}
		td img{width:20%;}
		</style>
		<script>
			$(function(){
				$("#btn").click(function(){
					alert("공공데이터를 검색합니다.");
					let txt = $("#txt").val();
					
					$.ajax({
						url: "/layout/SearchData",
						type: "get",
						data: {"txt":txt},
						dataType: "json",
						success: function(data){
							alert("성공");
							let iarray = data.response.body.items.item;
							let hdata = "";
							
							//console.log("iarray[0].galTitle 데이터: "+iarray[0].galTitle);
							
							for(let i=0;i<iarray.length;i++){
							hdata += '<tr>';
							hdata += '<td>'+iarray[i].galContentId+'</td>';
							hdata += '<td>'+iarray[i].galTitle+'</td>';
							hdata += '<td>'+iarray[i].galCreatedtime+'</td>';
							hdata += '<td>'+iarray[i].galPhotographyLocation+'</td>';
							hdata += '<td>'+iarray[i].galPhotographer+'</td>';
							hdata += '<td>'+iarray[i].galWebImageUrl+'</td>';
							hdata += '<td><img src="'+iarray[i].galWebImageUrl+'"</td>';
							hdata += '</tr>';
							}
							
							$("#content").html(hdata);
							
						},
						error: function(){
							alert("실패");
						}
						
						
					});//Ajax
					
				});
			});
		
		</script>
	</head>
	<body>
	<div>
		<h1>공공데이터 정보</h1>
		<input type="text" name="txt" id="txt">
		<button type="button" id="btn">검색</button>
		<br><br>
		<div id="body">
			<table>
			<colgroup>
			<col width="8%">
			<col width="18%">
			<col width="11%">
			<col width="16%">
			<col width="15%">
			<col width="23%">
			<col width="9%">
			</colgroup>
			<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>촬영일</th>
				<th>촬영장소</th>
				<th>촬영자</th>
				<th>URL</th>
				<th>사진</th>
			</tr>
			</thead>
			<tbody id="content">
			
			</tbody>
			</table>
		
		</div>
	</div>
	</body>
</html>