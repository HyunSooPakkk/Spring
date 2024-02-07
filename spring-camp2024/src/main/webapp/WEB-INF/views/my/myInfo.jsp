<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 	    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	    <meta content="" name="description">
	    <meta content="" name="keywords">
	 	 <meta name="google-signin-client_id" content="YOUR_CLIENT_ID.apps.googleusercontent.com">
		
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
	    <link href="../assets/css/my/myInfo.css" rel="stylesheet">
		<title>내 정보 수정</title>
	</head>
	<body>
	<!-- ======= Header ======= -->
	<%@include file="../include/header.jsp"  %>
	<!-- End Header -->
	<section>
		<form name="myInfoUpdateFrm" method="post" action="myInfoUpdate">
			<div id="subBanner"></div>
			<div id="sub_top_area">
				<h3>내 정보 수정</h3>
			</div>
			
			<!-- 비밀번호 변경 스크립트 시작 -->
			<script> 
			$(function(){
				
				$("#emailList").change(function(){
					if($("#emailList").val()==""){
						$("#mail_tail").val();
						$("#mail_tail").prop("readonly",false);
					}else{
						$("#mail_tail").val($("#emailList").val());
						$("#mail_tail").prop("readonly",true);
					}
				});//emailList
				
				$("#pw2").keyup(function(){
					if($("#pw2").val()==""){
						$("#pwCheckTxt").text("비밀번호를 확인해주세요.");
						$("#pwCheckTxt").css("color","green");
						return false;
					}
					if($("#pw1").val()!=$("#pw2").val()){
						$("#pwCheckTxt").text("변경 및 사용 가능한 비밀번호입니다.");
						$("#pwCheckTxt").css("color","blue");
					} else {
						$("#pwCheckTxt").text("기존 비밀번호와 동일한 비밀번호로는 변경이 불가합니다.");
						$("#pwCheckTxt").css("color","red");
					}//if-else(비밀번호 변경 확인)
				});//#pw2.keyup 		
				
				
			   $("#updateBtn").click(function(){
			   		alert("회원정보를 수정합니다."); 
			   		
			   		
			   		myInfoUpdateFrm.submit();
						
			   		});//UpdateBtn
			   		
			});//JQuery
			</script>
			<!-- 비밀번호 변경 스크립트 끝 -->
			
			
			   	
			
			
			
			<fieldset class="fieldset_class">
			  <dl id="join_picture_dl">
					<dt>
						<div></div>
						<label for="name">프로필 사진</label>
					</dt>
					<dd class="photoBoxMI">
						<div class="photoMI"><img src="${udto.m_img}"></div>
			          	<div class="inputMI" ><input type="file" name="files" id="files"></div>
					</dd>
				</dl>
				
				<dl id="join_name_dl">
					<dt>
						<div></div>
						<label for="name" readonly>이름</label>
					</dt>
					<dd>
						${udto.name}
					</dd>
				</dl>
				<dl id="join_id_dl_MI">
					<dt>
						<div></div>
						<label for="id" readonly>아이디</label>
					</dt>
					<dd>
						${udto.id}
					</dd>
				</dl>
				<dl id="join_pw1_dl">
					<dt>
						<div></div>
						<label for="pw1">기존 비밀번호</label>
					</dt>
					<dd>
						<input type="password" id="pw1" name="pw1" value="${udto.pw}" minlength="8" required />
					</dd>
				</dl>
				<dl id="join_pw2_dl">
					<dt>
						<div></div>
						<label for="pw2">신규 비밀번호</label>
					</dt>
					<dd>
						<input type="password" id="pw2" name="pw2" minlength="8" required />
						<span id="pwCheckTxt">※비밀번호를 확인해주세요.</span><br>
						<span>영문, 숫자, 특수문자 중 2종류 조합 시 10자리 이상 입력 | 영문, 숫자, 특수문자 모두 조합 시 8자리 이상 입력</span><br>
						
					</dd>
				</dl>
				
				<dl id="join_name_dl">
					<dt>
						<div></div>
						<label for="nickname">닉네임</label>
						
					</dt>
					<dd>
						<input type="text" id="nickName" name="nickname" value="${udto.nickname}" required/>
						<span>최대 다섯 글자까지 입력해주세요.</span>
					</dd>
				</dl>
				<dl id="join_mail_dl">
					<dt>
						<div></div>
						<label for="mail_id">이메일</label>
					</dt>
					
					<dd>
					<c:set var="email" value="${fn:split(udto.email,'@')}"></c:set>
						<input type="hidden" id="email" name="email" value="" />
						<input type="text" id="mail_id" name="mail_id" value="${email[0]}" required />
						<span>@</span>
						<input type="text" id="main_tail" name="mail_tail" value="${email[1]}" required />
						<select id="emailList">
							<option value="" selected>직접 입력</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>    
							<option value="gmail.com">gmail.com</option>
						</select>
					</dd>
				</dl>
				
				<dl id="join_address_dl">
					<dt> 
						<div></div>
						<label for="">주소</label>
					</dt>
					<script>
					$(function(){
						$(".addressBtn").click(function(){
							 new daum.Postcode({
							        oncomplete: function(data) {
							            
								    $("#zonecode").val(data.zonecode);
								    $("#address").val(data.address);
							        }
							    }).open();
							
						});
					});
					</script>
					<dd>
					<c:set var="address" value="${fn:split(udto.address,',')}"></c:set>
						<input type="button" class="addressBtn" value="우편번호 검색"/>
						<br>
						<input type="text" id="zonecode" name="zonecode" value="${address[0]}" required />
						<input type="text" id="address" name="address" value="${address[1]}" required />
					</dd>
					
				</dl>
				
				<dl id="join_tell_dl">
					<dt>
						<div></div>
						<label for="f_tell">휴대전화</label>
					</dt>
					<dd>
					<c:set var="mobNum" value="${fn:split(udto.phone,'-')}"></c:set>
						<input type="text" id="f_tell" name="f_tell" maxlength="3" value="${mobNum[0]}" required />
						<span> - </span>
						<input type="text" id="m_tell" name="m_tell" maxlength="4" value="${mobNum[1]}" required />
						<span> - </span>
						<input type="text" id="l_tell" name="l_tell" maxlength="4" value="${mobNum[2]}" required />
					</dd>
				</dl>
			
			</fieldset>

			
			
			<fieldset class="fieldset_class">
				
				<dl id="join_interests_dl">
					<dt>
						<label id="genderLb">지역</label>
					</dt>
					<dd>
						<ul>
							<li>
								<input type="checkbox" name="searchDo" id="c_do01" class="check01" value="${udto.local}" title="1"/>
								<label for="c_do01">서울시</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do02" class="check02" value="${udto.local}" title="2"/>
								<label for="c_do02">부산시</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do03" class="check03" value="${udto.local}" title="3"/>
								<label for="c_do03">대구시</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do04" class="check04" value="${udto.local}" title="4"/>
								<label for="c_do04">인천시</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do05" class="check05" value="${udto.local}" title="5"/>
								<label for="c_do05">광주시</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do06" class="check06" value="${udto.local}" title="6"/>
								<label for="c_do06">대전시</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do07" class="check07" value="${udto.local}" title="7"/>
								<label for="c_do07">울산시</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do08" class="check08" value="${udto.local}" title="8"/>
								<label for="c_do08">세종시</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do09" class="check09" value="${udto.local}" title="9"/>
								<label for="c_do09">경기도</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do10" class="check10" value="${udto.local}" title="10"/>
								<label for="c_do10">강원도</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do11" class="check11" value="${udto.local}" title="11"/>
								<label for="c_do11">충청북도</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do12" class="check12" value="${udto.local}" title="12"/>
								<label for="c_do12">충청남도</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do13" class="check13" value="${udto.local}" title="13"/>
								<label for="c_do13">전라북도</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do14" class="check14" value="${udto.local}" title="14"/>
								<label for="c_do14">전라남도</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do015" class="check15" value="${udto.local}" title="15"/>
								<label for="c_do15">경상북도</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do16" class="check16" value="${udto.local}" title="16"/>
								<label for="c_do16">경상남도</label>
							</li>
							<li>
								<input type="checkbox" name="searchDo" id="c_do17" class="check17" value="${udto.local}" title="17"/>
								<label for="c_do17">제주도</label>
							</li>
						</ul>
					</dd>
				</dl>
			</fieldset>
			
			<div id="info_input_button">
				<input type="reset" id="cancelBtn" name="cancelBtn" value="취소하기" />
				<input type="submit" id="updateBtn" name="updateBtn" value="수정하기" />
			</div>
		</form>
		

		
	</section>
   <!-- ======= Footer ======= -->
   <%@include file="../include/footer.jsp" %>
   <!-- End Footer -->
		
	</body>
</html>