var sec = document.getElementById("seconds");
var hr = document.getElementById("hour");
var min = document.getElementById("minutes");
function getSecondsSinceStartOfDay() {
    return new Date().getSeconds() + 
      new Date().getMinutes() * 60 + 
      new Date().getHours() * 3600;
}

setInterval( function myclock () {
    var time = getSecondsSinceStartOfDay();
    console.log(time);
      // your code here
    sec.style.transform = 'rotate('+time+'deg)';
    var hour = Math.floor((time/3600));
    hr.style.transform = 'rotate('+hour+'deg)';
    var minutes = getMinutes(hour);
    min.style.transform = 'rotate('+minutes+'deg)';
    console.log(hour);
    console.log(min);
    time++;
}, 1000);
