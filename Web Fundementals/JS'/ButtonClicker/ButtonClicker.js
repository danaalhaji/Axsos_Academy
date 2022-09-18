function likes(element){
    if(element.name == "in"){
        element.innerText= "LogOut";
        element.name="out";
        
    }
    else if (element.name="out"){
        element.innerText= "Login";
        element.name="in";
    }
}
function removeele(element){
    element.remove();
}
function LikesAlert(element){
alert("Ninja was likes!");
}
