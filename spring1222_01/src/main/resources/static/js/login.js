		<script>
			$(function(){
				$("#saveBtn").click(function(){
					alert("test");					
					alert("아이디: "+$("#id").val());
					if($("#id").val().length<1){
						alert("아이디를 입력하셔야 진행 가능합니다.");
						$("#id").focus();
						return false;
					}
				});
			});
		</script>