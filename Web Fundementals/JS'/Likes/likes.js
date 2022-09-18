var count = 3;
var likesBt = document.querySelector(" #li");
function likesIncrease(){
    count++;
    console.log(count);
    likesBt.innerText = count+"Likes(s)";
}