const pn = document.querySelectorAll(".pn");
const pn2 = document.getElementsByClassName("pn")
const searchForm = document.getElementById("serachForm")
const pageNum = document.querySelector("#pageNum")

console.log(pn);
console.log(pn2);

pn.forEach(function(item){
	item.addEventListener('click', (e)=>{
		let n = e.target.getAttribute("data-pn")
		pageNum.value= n;
		searchForm.submit();
	})
});