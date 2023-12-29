<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>영화정보</title>
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
					alert("영화정보를 검색합니다.");
					let txt = $("#txt").val();
					
					$.ajax({
						url: "/layout/SearchScreen",
						type: "get",
						data: {"txt":txt},
						dataType: "json",
						success: function(data){
							alert("성공");
							console.log("전체 데이터: "+data);
							let iarray = data.boxOfficeResult.dailyBoxOfficeList;
							let hdata = "";
							
							
							for(let i=0;i<iarray.length;i++){
							hdata += '<tr>';
							hdata += '<td>'+iarray[i].rank+'</td>';
							hdata += '<td>'+iarray[i].rankInten+'</td>';
							hdata += '<td>'+iarray[i].movieNm+'</td>';
							hdata += '<td>'+iarray[i].openDt+'</td>';
							hdata += '<td>'+iarray[i].salesAcc.toLocaleString('ko-KR')+'</td>';
							hdata += '<td>'+iarray[i].audiAcc.toLocaleString('ko-KR')+'</td>';
							hdata += '<td></td>';
							hdata += '</tr>';
							}
							
							/* <th>순위</th>
							<th>전일대비순위</th>
							<th>영화제목</th>
							<th>개봉일</th>
							<th>누적관객수</th>
							<th>누적판매액</th>
							<th>포스터</th> */
							
							$("#filmData").html(hdata);
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
		<h1>영화 정보</h1>
		<input type="text" name="txt" id="txt">
		<button type="button" id="btn">검색</button>
		<br><br>
		<div id="body">
			<table>
			<colgroup>
			<col width="8%">
			<col width="8%">
			<col width="24%">
			<col width="13%">
			<col width="20%">
			<col width="17%">
			<col width="10%">
			</colgroup>
			<thead>
			<tr>
				<th>순위</th>
				<th>전일대비순위</th>
				<th>영화제목</th>
				<th>개봉일</th>
				<th>누적관객수</th>
				<th>누적판매액</th>
				<th>포스터</th>
			</tr>
			</thead>
			<tbody id="filmData"></tbody>
			</table>
		
		</div>
	</div>
	</body>
</html>