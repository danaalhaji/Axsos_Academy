function PizzaOven ( crustType, sauceType,cheese, toppings){
    var Pizza={} ;
    Pizza.crustType =  [
        "deep dish",
        "hand tossed",
        "thin and crispy",
        "cauliflower",
        "gluten free",
        "hawaiian bread"
    ];
    Pizza.sauceType = sauceType;
    Pizza.cheese = cheese;
    Pizza.toppings = toppings;
    return Pizza;
    }
    function randomPizza(arr){
    var random= arr[Math.floor(Math.random()*myArray.length)];
    return random;
    }
    var pizzaArray=[]
    var p1= PizzaOven(p1.crustType[0],);
    pizzaArray.push(p1);
    // console.log("This is the first Pizza");
    // console.log(p1);
    // var p2 = PizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);
    // console.log("This is the second Pizza");
    // // pizzaArray.push(p2);
    // // console.log(p2);
    // var p3 = PizzaOven("deep dish", "traditional", ["mozzarella", "chedder"], ["olives", "sausage"]);
    // console.log(p3);
    // var p4 = PizzaOven("deep dish", "white sauce", ["mozzarella", "chedder"], ["mushrooms", "peper", "chicken","olive"]);
    // console.log(p4);
