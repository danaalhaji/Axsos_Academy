// Define the needed variable// 
var count = 0;   // define counter for increasing the card
var numberOfPurchase = document.getElementById('purchaseCount');  // define the and get the element beside the cart
var sortingType = document.getElementById('sortType');  // define the sorting type description 
// function for increasing the value in the cart when pressing buy
function increaseCart(){
    count ++;
    numberOfPurchase.innerText = count;
}
// function for contact number
function alertLinks(){
    alert("Contact us at 555-5555");
}
// function for change the selection and sorting type 
function changeTheOrder(option){
    if(option.value == "price"){
        console.log("price");
        sortingType.innerText = "Price";
    }
    if(option.value == "bestSelling"){
        console.log("bestSelling");
        sortingType.innerText = "Best Selling";
    }
}