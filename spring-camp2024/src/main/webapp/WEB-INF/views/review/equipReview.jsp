<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑용품리뷰 - 리스트</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Amatic+SC:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="/assets/vendor/aos/aos.css" rel="stylesheet">
<link href="/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/assets/css/main2.css" rel="stylesheet">
<link href="/assets/css/review/review2.css" rel="stylesheet" type="text/css">
<link href="/assets/css/review/campsearch1.css" rel="stylesheet" type="text/css">
<link href="/assets/css/review/header2.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- ======= Header ======= -->
	<%@include file="../include/header.jsp"%>
	<!-- End Header -->
	<br>
	<br>
	<br>
	<div id="contentWrapper">
		<div id="contentWrap">
			<link type="text/css" rel="stylesheet" href="#">
			<div id="content">
				<div id="bbsData">
					<div class="page-body">
						<div class="camp-img-div">
							<img src="../assets/img/campReview/free-icon-forest-8856738.png"
								alt="캠핑리뷰이미지" style="position: relative; left: 475px;">
							<h1 style="text-align: center;">캠핑용품리뷰</h1>
						</div>
						<br> <br> <br>
								<div class="bbs-sch">
									<form action="#" name="form1">
										<input type="hidden" name="s_id" value=""> <input
											type="hidden" name="code" value="ocamall_image1"> <input
											type="hidden" name="page" value="1"> <input
											type="hidden" name="type" value="s"> <input
											type="hidden" name="board_cate" value=""> <input
											type="hidden" name="review_type" value="">
										<!-- .검색 폼시작 -->
										<fieldset>
											<legend>게시판 검색 폼</legend>
											<label> 
											<input type="checkbox" name="shname" value="ok" onclick="change(1);" class="MS_input_radio">이름</label> 
											<label> <input type="checkbox" name="ssubject" value="ok" onclick="change(2);" checked="checked"
												class="MS_input_checkbox"> 제목</label> 
											<label> <input type="checkbox" name="scontent" value="ok" onclick="change(3);" class="MS_input_checkbox">내용</label> 
											<span class="key-wrap"> 
											<input type="text" name="stext" value="" class="MS_input_txt"> <a href="javascript:document.form1.submit();"> 
											<img src="https://image.makeshop.co.kr/makeshop/d3/basic_simple/bbs/btn_bbs_sch.gif" alt="검색" title="검색"></a>
											</span>
										</fieldset>
									</form>
								<!-- .검색 폼 끝 -->
								</div>
								
							<div class="bbs-tit">
								<div class="viewtab-review">
									<input type="radio" name="tabreview" id="tabreview1">
									<label for="tabreview1">캠핑장리뷰</label>
									<input type="radio" name="tabreview" id="tabreview2" checked> 
									<label for="tabreview2">캠핑용품리뷰</label>
								</div>
						<div class="reviewbox2">
							</div> 
							
						</div>
							<!-- bbs-tit  -->
							
					
						<!-- 카드형 리스트 -->
						<div class="list_wrap" style="height: 1180px;  border-top: 3px solid #009223; border-bottom: 3px solid #009223;">
							<ul>
								<li class="item item1">
									<div class="image">										
										<img src="../assets/img/campReview/2인패키지.png"
											style="width: 100%; height: 200px; border-radius: 10px;" />
									</div>
									<div class="cont">
										<strong>2인 패키지 대여 후기</strong>
										<p>${session_id}님</p>
										<p>캠브릿지 2인 패키지</p>
										<p>
											친구랑 주말 글램핑 다녀왔는데 <br>
											딱 필수템 구성이예요 좋아요 :) <br>
										</p>
										<div class="heartwrap">
											<span class="date"><i class="fa fa-clock-o"
												aria-hidden="true"></i> 1년 전</span> <span class="reviewhit">269</span>
											<img
												src="https://www.5gcamp.com/modules/usemarket/theme/_pc/default/image/heart-o.svg"
												alt="" width="20" class="heart1">
										</div>
										<a href="review_equip">바로가기</a>
									</div>
								</li>
								
								
								<li class="item item1">
									<div class="image">
										<img src="../assets/img/campReview/매트.png"
											style="width: 260px; height: 200px; border-radius: 10px;" />
									</div>
									<div class="cont">
										<strong>폭신폭신</strong>
										<p>${session_id}님</p>
										<p>4인용 방수매트</p>
										<p>
											음료수 쏟아서 바로 닦았는데 <br>
											스며드는 것 없이 깔끔하게 닦였어요<br>
										</p>
										<div class="heartwrap">
											<span class="date"><i class="fa fa-clock-o"
												aria-hidden="true"></i> 1년 전</span> <span class="reviewhit">82</span>
											<img
												src="https://www.5gcamp.com/modules/usemarket/theme/_pc/default/image/heart-o.svg"
												alt="" width="20" class="heart1">
										</div>
										<a href="review_equip">바로가기</a>
									</div>
								</li>
								
								
								<li class="item item1">
									<div class="image">
										<img src="../assets/img/campReview/4인테이블의자.png"
											style="width: 260px; height: 200px; border-radius: 10px;" />
									</div>
									<div class="cont">
										<strong>완전 편해요</strong>
										<p>${session_id}님</p>
										<p>4인 테이블 의자</p>
										<p>
											캠핑용이 다 비슷비슷해서 <br>
											별 기대 안했는데 편해요! <br>
										</p>
										<div class="heartwrap">
											<span class="date"><i class="fa fa-clock-o"
												aria-hidden="true"></i> 1년 전</span> <span class="reviewhit">170</span>
											<img
												src="https://www.5gcamp.com/modules/usemarket/theme/_pc/default/image/heart-o.svg"
												alt="" width="20" class="heart1">
										</div>
										<a href="review_equip">바로가기</a>
									</div>
								</li>
								
								
								<li class="item item1">
									<div class="image">
										<img src="../assets/img/campReview/그릴.png"
											style="width: 260px; height: 200px; border-radius: 10px;" />
									</div>
									<div class="cont">
										<strong>이 그릴 가성비 끝판왕</strong>
										<p>${session_id}님</p>
										<p>바베큐 그릴</p>
										<p>
											고기 안 눌러붙고 좋아요 <br>
											숯 넣을 공간도 넉넉합니다 <br>
										</p>
										<div class="heartwrap">
											<span class="date"><i class="fa fa-clock-o"
												aria-hidden="true"></i> 1년 전</span> <span class="reviewhit">74</span>
											<img
												src="https://www.5gcamp.com/modules/usemarket/theme/_pc/default/image/heart-o.svg"
												alt="" width="20" class="heart1">
										</div>
										<a href="review_equip">바로가기</a>
									</div>
								</li>
								
								
								<li class="item item1">
									<div class="image">
										<img src="../assets/img/campReview/텐트.png"
											style="width: 260px; height: 200px; border-radius: 10px;" />
									</div>
									<div class="cont">
										<strong>방풍, 방충 개굿</strong>
										<p>${session_id}님</p>
										<p>2-3인용 텐트</p>
										<p>
											얇은데 바람 잘 막아지고 <br>
											방충망 엄청 탄탄해여 <br>
										</p>
										<div class="heartwrap">
											<span class="date"><i class="fa fa-clock-o"
												aria-hidden="true"></i> 1년 전</span> <span class="reviewhit">155</span>
											<img
												src="https://www.5gcamp.com/modules/usemarket/theme/_pc/default/image/heart-o.svg"
												alt="" width="20" class="heart1">
										</div>
										<a href="review_equip">바로가기</a>
									</div>
								</li>
								
								
								<li class="item item1">
									<div class="image">
										<img src="../assets/img/campReview/랜턴.png"
											style="width: 260px; height: 200px; border-radius: 10px;" />
									</div>
									<div class="cont">
										<strong>딱 적당한 밝기</strong>
										<p>${session_id}님</p>
										<p>충전식 LED 랜턴</p>
										<p>
											야외 나들이용으로 장만했는데 <br>
											한 번 충전하면 엄청 오래가요 <br>
										</p>
										<div class="heartwrap">
											<span class="date"><i class="fa fa-clock-o"
												aria-hidden="true"></i> 1년 전</span> <span class="reviewhit">183</span>
											<img
												src="https://www.5gcamp.com/modules/usemarket/theme/_pc/default/image/heart-o.svg"
												alt="" width="20" class="heart1">
										</div>
										<a href="review_equip">바로가기</a>
									</div>
								</li>
							</ul>
						</div>
						</div>
				</div>

						<!-- 하단 페이징 & 버튼 -->
						<div class="bbs-btm">
						
						<div>
							<ul class="page-num-review">
								<li class="first-num"></li>
								<li class="prev-num"></li>
								<li class="num-review">1</li>
								<li class="num-review">2</li>
								<li class="num-review">3</li>
								<li class="num-review">4</li>
								<li class="num-review">5</li>
								<li class="num-review">6</li>
								<li class="num-review">7</li>
								<li class="num-review">8</li>
								<li class="num-review">9</li>
								<li class="num-review">10</li>
								<li class="next-num"></li>
								<li class="last-num"></li>
							</ul>
						</div>
							<!-- //하단 페이징 & 버튼 -->
						
							<div class="bbs-link">
								<a href="#"
									class="CSSbuttonWhite">글쓰기</a>
							</div>

						</div>
						<!-- //하단 페이징 & 버튼 -->

					</div>
					<!-- .page-body -->
				</div>
				<!-- #bbsData -->
			</div>
			<!-- #content -->
		</div>
		<!-- #contentWrap -->
	


		<!-- ======= Footer ======= -->
		<%@include file="../include/footer.jsp"%>
		<!-- End Footer -->
</body>
</html>