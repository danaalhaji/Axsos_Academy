var degreesLow = document.querySelectorAll("#lowerTemp");
var degreesHigh = document.querySelectorAll("#HighTemp");
// var select = document.getElementById('seletItem');
function CityAlert(){
    alert("Loading weather page....");
}
function dismissCookie(element){
    element.parentElement.remove();
}
function changeDegree(select){

    if (select.value == "F°"){
        for(var i =0; i< degreesLow.length ; i++){
        degreesLow[i].innerText = Math.floor(((parseInt(degreesLow[i].innerText))*1.8)+32)+"°";
        degreesHigh[i].innerText = Math.floor(((parseInt(degreesHigh[i].innerText))*1.8)+32)+"°";
    } 
    } 
    if (select.value == "C°") { 
        for(var i =0; i< degreesLow.length ; i++){
        degreesLow[i].innerText = Math.ceil(((parseInt(degreesLow[i].innerText))-32)*.55555)+"°";
        degreesHigh[i].innerText = Math.ceil(((parseInt(degreesHigh[i].innerText))-32)*.55555)+"°";
        }
}
}