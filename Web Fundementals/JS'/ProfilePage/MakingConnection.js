var editP = document.querySelector("#namePerson");
console.log(editP);
function changeName(){
    console.log("jgjhgjhghg ")
    editP.textContent="Dana";
}
var removeReq = document.querySelector("#request1");
var removeReq2 = document.querySelector("#request2");
var connectionDiv1 = document.getElementsByClassName("Connections");
var connectionDiv2 = document.getElementsByClassName("Connections2");
var span = document.getElementById('spans');
var span2 = document.getElementById('spans2');
var acceptBT = document.getElementById('accept1');
var acceptBT2 = document.getElementById('accept2');
var count = 2;
var count2 = 500;
function removeRequest(){
    count--;
    span.innerText = count;
    removeReq.remove();
    if(acceptBT.alt == "accept"){
        console.log("tick");
        count2++;
        span2.innerText = count2;
    }
}
function removeRequest2(){
    removeReq2.remove();
    count--;
    span.innerText = count;
    if(acceptBT2.alt == "accept2"){
        console.log("tick");
        count2++;
        span2.innerText = count2;
    }
} 
function fun1(elem){
elem.parentElement.remove();
}

