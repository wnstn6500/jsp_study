/**
 * 
 */

// 전체 체크박스를 클릭했을 때
const checkAll = document.getElementById("checkAll");
const ch = document.querySelectorAll(".ch")
const frm = document.getElementById("frm")
const del = document.getElementById("del")
const add = document.getElementById("add")

add.addEventListener("click", ()=>{
	//체크 된것들이 하나 이상인지 검증
	frm.setAttribute("action","/account/add")
	frm.submit();
})

del.addEventListener("click",()=>{
	// 체크 된것들이 하나 이상인지 검증
	frm.submit();
})

let num = 0;

checkAll.addEventListener("click", ()=>{
	
	ch.forEach((item)=>{
		item.checked=checkAll.checked
	});
	
	
	
})

ch.forEach((item)=>{
	item.addEventListener("click",()=>{
		let flag = true;
		ch.forEach((c)=>{
			if(!c.checked){
				flag=false;
				return;
			}
		})
		checkAll.checked=flag;
	})
})