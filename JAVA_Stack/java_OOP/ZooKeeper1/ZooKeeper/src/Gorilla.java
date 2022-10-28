
public class Gorilla extends Mammal{
public void throwSomething() {
	this.energylevel-=5;
	System.out.println("The Gorilla Has Thrown Something and It's Enegrey Decreased by 5");
}
public void  eatBananas() {
	this.energylevel+=10;
	System.out.println("The Gorilla Has eaten a Banana and It's Energey Increased By 10!");
}
public void climb() {
	this.energylevel -=10;
	System.out.println("This Gorilla is Climbing and It's Lossing Energy By 10!");
}
}
