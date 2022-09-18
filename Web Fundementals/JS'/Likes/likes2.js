var count = 9;
var count2 = 12;
var count3 = 9;
var likesBt = document.querySelector("#li");
var likesBt2 = document.querySelector("#li2");
var likesBt3 = document.querySelector("#li3");
function likesIncrease(){
    count--;
    console.log(count);
    likesBt.innerText = count+"Likes(s)";
    }
    function likesIncrease1(){
        count2--;
        console.log(count);
        likesBt2.innerText = count2+"Likes(s)";
        }
    function likesIncrease2(){
        count3--;
        console.log(count3);
        likesBt3.innerText = count3+"Likes(s)";
    }