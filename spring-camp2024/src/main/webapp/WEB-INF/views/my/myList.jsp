<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나의 게시글</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	    <meta content="" name="description">
	    <meta content="" name="keywords">
	
	    <!-- Favicons -->
	    <link href="assets/img/favicon.png" rel="icon">
	    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
	
	    <!-- Google Fonts -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Amatic+SC:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
	
	    <!-- Vendor CSS Files -->
	    <link href="../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <link href="../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
	    <link href="../assets/vendor/aos/aos.css" rel="stylesheet">
	    <link href="../assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
	    <link href="../assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
	
	    <!-- Template Main CSS File -->
	    <link href="../assets/css/main2.css" rel="stylesheet">
		<link href="../assets/css/header.css" rel="stylesheet">
		<link href="../assets/css/my/myPageList.css" rel="stylesheet">
	</head>
	<body>
	<!-- ======= Header ======= -->
	<%@include file="../include/header.jsp" %>
	<!-- End Header -->
	
		<section class="myList">
			<!-- 자유게시판 리스트 -->
			<img src="../assets/img/mypage/myList_icon.png">
	    	<h1>나의 게시글</h1>
		    <!-- 검색창 -->
		    <div class="searchDiv">
			  <form action="" method="get" name="searchFrm">
			    <select name="searchTitle" id="searchTitle" class="searchTitle">
			       <option value="all">전체</option>
			       <option value="btitle">제목</option>
			       <option value="bcontent">내용</option>
			       <option value="id">작성자</option>
			    </select>
			    	<input type="text" name="searchWord" id="searchWord" class="searchWord" placeholder=" 검색어를 입력해주세요.">
			    	<button type="button" id="searchBtn" class="searchBtn">검색</button>
			  </form>
			</div>
			
			<table>
		  		<div class="page-title myList_th">
			      <colgroup>
			        <col width="8%">
			        <col width="12%">
			        <col width="44%">
			        <col width="15%">
			        <col width="10%">
			        <col width="10%">
			      </colgroup>
			      
			      <tr>
			        <th>No.</th>
			        <th>게시글 유형</th>
			        <th>제목</th>
			        <th>작성자</th>
			        <th>작성일</th>
			        <th>조회수</th>
			      </tr>
			      
			      <c:forEach var="fdto" items="${list}">
			      <tr>
			        <td id="No">${fdto.f_bno}</td>
			        <td style="color: purple; font-weight: bold;">
			        <c:if test="${fdto.f_btype=='instapayment'}">[자유게시판]</c:if>
			        </td>
			        <td class="table-title"><a href="../community/fView">${fdto.f_btitle}</a></td>
			        <td>${fdto.id}</td>
			        <td>${fdto.f_bdate}</td>
			        <td>${fdto.f_bhit}</td>
			      </tr>
			      </c:forEach>
			      
			      <c:forEach var="cpsRdto" items="${list2}">
			      <tr>
			        <td id="No">${cpsRdto.cps_bno}</td>
			        <td style="color:green; font-weight: bold;">[캠핑장리뷰]</td>
			        <td class="table-title"><a href="../review/review_site">${cpsRdto.cps_btitle}</a></td>
			        <td>${cpsRdto.id}</td>
			        <td>${cpsRdto.cps_bdate}</td>
			        <td>${cpsRdto.cps_bhit}</td>
			      </tr>
			      </c:forEach>
			      
			      <c:forEach var="tdto" items="${list3}">
			      <tr>
			        <td id="No">${tdto.t_bno}</td>
			        <td style="color:darkorange; font-weight: bold;">[캠핑꿀팁]</td>
			        <td class="table-title"><a href="../review/review_site">${tdto.t_btitle}</a></td>
			        <td>${tdto.id}</td>
			        <td>${tdto.t_bdate}</td>
			        <td>${tdto.t_bhit}</td>
			      </tr>
			      </c:forEach>
			      
			      <c:forEach var="cppRdto" items="${list4}">
			      <tr>
			        <td id="No">${cppRdto.cpp_bno}</td>
			        <td style="color:navy; font-weight: bold;">[캠핑용품리뷰]</td>
			        <td class="table-title"><a href="../review/review_equip">${cppRdto.cpp_btitle}</a></td>
			        <td>${cppRdto.id}</td>
			        <td>${cppRdto.cpp_bdate}</td>
			        <td>${cppRdto.cpp_bhit}</td>
			      </tr>
			      </c:forEach>
			      
			      
		  		</div>
		    </table>
			 
  			 	<button class="write" onclick="location.href='/'">메인홈</button>
	    	
	    	<!-- 하단넘버링 시작 -->
		     <ul class="page-num">
			      <li class="first"></li>
			      <li class="prev"></li>
			      <li class="num">1</li>
			      <li class="next"></li>
			      <li class="last"></li>
   			 </ul>
   			 <!-- 하단넘버링 끝 -->
		</section>
		
		<!-- ======= Footer ======= -->
	  	<%@include file="../include/footer.jsp" %>
	 	<!-- End Footer -->
	</body>
</html>