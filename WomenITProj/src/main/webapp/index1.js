/**
 * 
 */

 document.addEventListener('DOMContentLoaded', function() {

	let xhtp = new XMLHttpRequest();
	xhtp.open('get', 'book?cmd=list');
	xhtp.send();
	xhtp.onload = function() {
		let result = JSON.parse(xhtp.responseText);
		console.log(result)
		result.forEach(function(book) {
			document.querySelector('#show tbody').append(makeTr(book));
		})
	}

	//입력
	document.forms.bookFrm.addEventListener('submit', function(e) {
		e.preventDefault();
		let bCode = this.bookCode.value;
		let bName = this.bookTitle.value;
		let bAuth = this.author.value;
		let bPres = this.publisher.value;
		let bAmt = this.price.value;

		let xhtp = new XMLHttpRequest();
		xhtp.open('post', 'book');
		xhtp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xhtp.send(`bookCode=${bCode}&bookName=${bName}&bookAuth=${bAuth}&bookPres=${bPres}&bookAmt=${bAmt}&cmd=insert`);
		xhtp.onload = function() {
			let result = JSON.parse(this.responseText); 
			console.log(result);
			document.querySelector('#show tbody').append(makeTr(result));

			document.getElementById('bookCode').value = '';
			document.getElementById('bookTitle').value = '';
			document.getElementById('author').value = '';
			document.getElementById('publisher').value = '';
			document.getElementById('price').value = '';
		}

	})


})
let fields = ['bookCode', 'bookName', 'bookAuth', 'bookPres', 'bookAmt'];

function makeTr(book) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', book.bookCode);

	//체크박스
	let chck = document.createElement('input');
	chck.setAttribute('type', 'checkbox');
	chck.setAttribute('id', book.bookCode);
	let td2 = document.createElement('td');
	td2.append(chck);
	tr.append(td2);


	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = book[field];
		tr.append(td);
	})


	//삭제버튼
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.addEventListener('click', rowDelete, false);
	let td = document.createElement('td');
	td.append(btn);
	tr.append(td);

	//선택삭제
	document.getElementById('deleteSel').addEventListener('click', dSelected);



	return tr;
}

//삭제
function rowDelete() {
	let delId = this.parentElement.parentElement.getAttribute('id');
	console.log(delId);
	fetch('book', {
		method: 'post',
		headers: {
			'Content-type': 'application/x-www-form-urlencoded'
		},
		body: `cmd=delete&delId=${delId}`
	})
		.then(result => {
			return result.json();
		})
		.then(result => {
			console.log(result);
			this.parentElement.parentElement.remove();
		})
		.catch(err => {
			console.error(err);
		})
}

//선택삭제
function dSelected() {
	let checked = document.querySelectorAll('table > tbody > tr > td > input:checked');
	console.log(checked)
	checked.forEach(elem => {
		let seldelId = elem.parentElement.parentElement.getAttribute('id');
		console.log(seldelId);
		console.log(elem);

		let dAjax = new XMLHttpRequest();
		dAjax.open('post','book');
		dAjax.setRequestHeader('Content-type','application/x-www-form-urlencoded');
		dAjax.send(`cmd=delete&delId=${seldelId}`);
		dAjax.onload = function(){
			let result = JSON.parse(dAjax.responseText);
			if(result.retCode.includes('Success')){
				console.log(result.retCode)
				document.getElementById(seldelId).remove();
			}else{
				alert('처리중 에러발생.!')
			}
		}

	/*	fetch('book', {
		method: 'post',
		headers: {
			'Content-type': 'application/x-www-form-urlencoded'
		},
		body: `cmd=delete&delId=${seldelId}`
	})
		.then(result => {
			return result.json();
		})
		.then(result => {
			console.log(result);
			this.parentElement.parentElement.remove();
		})
		.catch(err => {
			console.error(err);
		})*/


	});
} 