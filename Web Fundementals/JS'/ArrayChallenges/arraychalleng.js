function alwaysHungry(arr) {
    var count=0;
    for(var i= 0; i < arr.length; i++){
        if (arr[i] == "food"){
        console.log("yummy");
        count++;
    }
    }
    if (count == 0){
        console.log("I'm hungry!");
    }
}
function highPass(arr, cutoff) {
    var filteredArr = [];
    for(var i = 0; i < arr.length; i++){
        if(arr[i] > cutoff){
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}
function betterThanAverage(arr) {
    var sum = 0;
    // calculate the average
    for( var i=0; i< arr.length; i++){
        sum+=arr[i];
    }
    var count = 0
    // count how many values are greated than the average
    var avg = sum / arr.length;
    for( var i = 0; i < arr.length; i++){
        if( arr[i] > avg){
            count++;
        }
    }
    return count;
}
function reverse(arr) {
    // your code here
    var temp;
    for(i = 0; i < arr.length; i++){
        temp= arr[arr.length-1-i];
        arr[arr.length-1-i]=arr[i];
        arr[i]=temp;
    }
    // we can use a built-in function arr.store.reverse.
    return arr;
} 
function fibonacciArray(n) {
    // the [0, 1] are the starting values of the array to calculate the rest from
    var fibArr = [0, 1];
    // your code here
    for(var i = 2; i< n; i++){
    fibArr.push(fibArr[i-2]+fibArr[i-1]);
    }
    return fibArr;
}
alwaysHungry([3.14, "food", "pie", true, "food"]);
// this should console log "yummy", "yummy"
alwaysHungry([4, 1, 5, 7, 2]);
// this should console log "I'm hungry"
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); // we expect back [6, 8, 10, 9]
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result); // we expect back 4 
var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result); // we expect back ["e", "d", "c", "b", "a"]
var result = fibonacciArray(10);
console.log(result); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]

