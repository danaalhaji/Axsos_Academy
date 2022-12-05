class Ninja{
    constructor(name){
        this.name=name;
        this.speed=3;
        this.strength=3;
        this.health = 0;
    }
    sayName(){
        console.log(this.name);
    }
    showStats(){
        console.log(`The Ninja name is: ${ this.name } and it now has health ${this.health} and it's strength :${this.strength}. also it has a speed of ${this.speed}`);
    }
    drinkSake(){
        this.health += 10;
    }
}
let ninja = new Ninja("dana");
ninja.showStats();
ninja.sayName();
ninja.drinkSake();
ninja.showStats();
