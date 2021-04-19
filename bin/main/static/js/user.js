let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
	},

	save: function() {
		alert('user의 save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password:  $("#password").val(),
			email: $("#email").val()
		};

		console.log(data);

		// ajax 호출시 default가 비동기 호출
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		$.ajax({
			type: "POST",
			url: "/blog/api/user",
			data: JSON.stringify(data), // http body데이터
			contentType: "application/json; charset=utf-8",//body데이터가 어떤 타입인지(MIME)
			dataType: "json"
		}).done(function(resp) {
			alert("회원가입이 완료되었습니다.");
			console.log(resp);
			location.href = "/blog";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
		;
	},


	login: function() {
		alert('user의 save함수 호출됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
		};

		$.ajax({
			type: "POST",
			url: "/blog/api/user/login",
			data: JSON.stringify(data), // http body데이터
			contentType: "application/json; charset=utf-8",//body데이터가 어떤 타입인지(MIME)
			dataType: "json"
		}).done(function(resp) {
			alert("로그인이 완료되었습니다.");
			location.href = "/blog";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	}
}

index.init();
