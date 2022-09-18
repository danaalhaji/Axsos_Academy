var i=0;
while(i<= 100){
    if ((i%5 == 0) && (i%3 == 0)){
        console.log("FizzBuzz");
    }
    else if(i%3 == 0){
        console.log("Frizz");
    }
    else if (i%5 == 0){
        console.log("Buzz");
    }
    else{
        console.log(i);
    }
    i++;
}