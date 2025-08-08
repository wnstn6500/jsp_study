const elements = document.querySelectorAll('.action');
const form = document.querySelector('#frm');
elements.forEach(el => {
	el.addEventListener('click', () => {
		const data = el.getAttribute('data-kind');
		if (data === 'd') {
			const proceed = window.confirm('Proceed Delete?');
			if (proceed) {
				form.setAttribute('action', './delete');
				form.setAttribute('method', 'post');
				form.submit();				
			}
		} else if (data === 'u'){
			form.setAttribute('action', './update');
			form.setAttribute('method', 'get');
			form.submit();						
		} else if (data === 'r') {
			form.setAttribute('method', 'get');
			form.setAttribute('action', './reply');
			form.submit();
		}
	});
});