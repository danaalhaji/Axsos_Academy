// problem one!
// ORIGINAL CODE 

console.log(hello);
var hello ="world"

//var hello;
//console.log(hello);
//hello ="world"
//undefined predicted 

////////////////////////////////////////////////////////
//*************** */ PROBLEM TWO*/ ********************
// ORIGINAL CODE
var needle = 'haystack';
test();
function test(){
    var needle = 'magnet';
    console.log(needle);
}

// var needle = 'haystack';
//var test.needle;
// test();
// function test(){
//     needle = 'magnet';
//     console.log(needle);
// }
///////////////////predicted output : 
////***************   magnet

////////////////////////////////////////////////////////
//*************** */ PROBLEM THREE*/ ********************
// ORIGINAL CODE
var brendan = 'super cool';
function print(){
    brendan = 'only okay';
    console.log(brendan);
}
console.log(brendan);

//var brendan = 'super cool'
// function print(){
//  brendan ='only okay'
//console.log(brendan);
//}
//console.log(brendan);
////////////////// */predicted output : */ /////////////////////// 
////***************       super cool     ***************////


////////////////////////////////////////////////////////
//*************** */ PROBLEM FOUR*/ ********************
// ORIGINAL CODE
var food = 'chicken';
console.log(food);
eat();
function eat(){
    food = 'half-chicken';
    console.log(food);
    var food = 'gone';
}

////////////////// */predicted output : */ /////////////////////// 
////***************       chicken
//                        half-chicken                      
// ***************////


////////////////////////////////////////////////////////
//*************** */ PROBLEM FIVE*/ ********************
// ORIGINAL CODE
// mean();
// console.log(food);
// var mean = function() {
//     food = "chicken";
//     console.log(food);
//     var food = "fish";
//     console.log(food);
// }
// console.log(food);
////////////////// */predicted output : */ /////////////////////// 
////***************       ERROR       ***************////



////////////////////////////////////////////////////////
//*************** */ PROBLEM SIX*/ ********************
// ORIGINAL CODE
console.log(genre);
var genre = "disco";
rewind();
function rewind() {
    genre = "rock";
    console.log(genre);
    var genre = "r&b";
    console.log(genre);
}
console.log(genre);


////////////////// */predicted output : */ /////////////////////// 
////***************      undefined 
//                       ROCK
//                       R&B
//                      DISCO   
//                                   ***************////

////////////////////////////////////////////////////////
//*************** */ PROBLEM SEVEN*/ ********************
// ORIGINAL CODE
dojo = "san jose";
console.log(dojo);
learn();
function learn() {
    dojo = "seattle";
    console.log(dojo);
    var dojo = "burbank";
    console.log(dojo);
}
console.log(dojo);
