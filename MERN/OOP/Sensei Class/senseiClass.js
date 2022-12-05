class Ninja{
    constructor(name){
        this.name=name;
        this.speed=3;
        this.strength=3;
        this.health = 10;
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
class Sensei extends Ninja{
    constructor(name){
        super(name);
        this.health+=200;
        this.wisdom = 10;
    }
    speakWisdom(){
        console.log("What one programmer can do in one month, two programmers can do in two months.");
    }
}

let ninja = new Ninja("dana");
ninja.showStats();
ninja.sayName();
ninja.drinkSake();
ninja.showStats();
// example output
const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
// -> "What one programmer can do in one month, two programmers can do in two months."
superSensei.showStats();
// -> "Name: Master Splinter, Health: 210, Speed: 10, Strength: 10"

