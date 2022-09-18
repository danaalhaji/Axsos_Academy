// define needed values for calculations
var value1;
var value2;
var currentValue = "";
var op;

function getDisplay(){
    return document.getElementById('display');
}
// check and print numbers
function press (number) {
currentValue += parseFloat(number);
console.log(value1,value2);
if(op){
    value2 = parseFloat(currentValue);
}

else {
    value1= parseFloat(currentValue);
}

getDisplay().innerText = currentValue;
}
// start the calcualtions
function setOP(oper){
op = oper;
currentValue= "";
getDisplay().innerText = "0";
}

function calculate(){
var result;
if (op === "+"){
    result = value1 + value2;
}
else if (op === "-"){
    result = value1 - value2;
}
else if (op === "*"){
    result = value1 * value2;
}
else if (op === "/"){
    result = value1 * value2;
}

getDisplay().innerText = result;
}