const add = document.getElementById("add");
const result = document.getElementById("result")
const del = document.querySelectorAll(".del")
const deleteFile = document.querySelectorAll(".deleteFile");


let count = result.getAttribute('data-file-count');

deleteFile.forEach((item)=>{
	item.addEventListener("click",function(){
		
		let flag =confirm("정말??")
		
		if(!flag){
			return;
		}
		
		let fn=item.getAttribute("data-file-num")
		console.log(fn)
		
		//fetch, axios
		let params = new URLSearchParams();
		params.append("fileNum", item.getAttribute("data-file-num"))
		console.log("시작")
		
		fetch(`./fileDelete`, {
			method:"post",
			body:params
		})
		.then(r=>r.text())
		.then(r=>{
			 // 텍스트로 받을땐 trim()으로 앞 뒤 공백 없애기 추천
			if(r.trim()==1){
				count--;
				item.remove();
			}else{
				alert('삭제 실패');
			}
		})
		
		console.log("finish")
		
	})
	
	
})


add.addEventListener("click", ()=>{
	if(count<5){
	/*result.innerHTML+=`<div class="mb-3">
						<input type="file" class="form-control" name="attaches">
						<button class="del" type=button>X</button>
					  </div>`*/
					  
	let div = document.createElement("div") //<div></div>
	
	
	div.classList.add("mb-3")
	
	let ch = document.createElement("input");
	ch.setAttribute("type","file");
	ch.classList.add("form-control")
	ch.setAttribute("name","attaches")				  
					  
	div.append(ch)
	
	ch = document.createElement("button");
	ch.classList.add("del")
	ch.setAttribute("type","button");
	ch.innerText="X"
	
	div.append(ch);
		
	result.append(div);
	count++;
	}
})
result.addEventListener("click", (e)=>{
	if(e.target.classList.contains("del")){
		e.target.parentElement.remove();
		count--;
	}
})

