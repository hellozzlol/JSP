/**
 * 
 */

 document.addEventListener('DOMContentLoaded', function() {

	let xhtp = new XMLHttpRequest();
	xhtp.open('get', 'WomenServlet?cmd=list');
	xhtp.send();
	xhtp.onload = function() {
		let result = JSON.parse(xhtp.responseText);
		console.log(result)
		result.forEach(function(book) {
			document.querySelector('#show tbody').append(makeTr(book));
		})
	}
})

	//회원정보 => tr생성
	function makeTr(book) {
		console.log(book);
		console.log(book.BookCode);
		let fields = ['BookCode', 'BookName', 'BookWriter', 'Bookpublisher', 'BookPrice'];
		let tr = document.createElement('tr');
		let tbody = document.querySelector('#show tbody')
		//tr.setAttribute('id', book.BookCode);//tr 의 아이디 값 활용
		tr.setAttribute('class', book.BookCode)
		//tr.addEventListener('click',showDetail)
		fields.forEach(field => {
			let td = document.createElement('td');
			td.innerHTML = book[field]
			tr.append(td);
			console.log(td);
		});
			tbody.append(tr);


	}

	 //form 기본 기능 =>ajax처리.(XMLHttpRequest,fetch)
	 document.forms.bookFrm.addEventListener("submit", function(e) {
	 	e.preventDefault();
	 	let formData = new FormData(e.target);// e.target = form
	 	for (let ent of formData.entries()) {
	 		console.log(ent);
	 	};
	 	fetch('WomenServlet")', {
	 		method: 'get',
	 		body: formData
	 	})//get : url,post : 추가정보 지정.
	 		.then(function(result) {
	 			return result.json();
	 		})
	 		.then(function(result) {
	 			console.log(result);
	 		})
	 		.catch(function(err) {
	 			console.error(err);
	 		})
	 })
	






	