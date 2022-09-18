console.log("This is the odd values from 1 to 20");
for(var i=1; i<=20; i+=2){
    console.log(i);
}
console.log("This is divisible by 3 number from 100 to 0");
for ( var i=100; i>0; i--){
    if (i%3==0){
        console.log(+i);
    }
}
console.log("This is an array")
var arr=[4, 2.5, 1, -0.5, -2, -3.5];
for(var j=0; j< arr.length; j++){
    console.log(arr[j]);
}
console.log("This is Sigma for number from 0 to 100");
var sum=0;
i=1;
while(i <= 100 ){
    sum=sum+i;
    i++
}
console.log(sum);
i=1;
console.log(i);
var multi=1;
while(i<=12){
multi*=i;
i++;
}
console.log(multi);