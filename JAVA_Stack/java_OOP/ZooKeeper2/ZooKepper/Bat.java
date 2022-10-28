
public class Bat extends Mammal {
public Bat() {
	this.energylevel = 300;
}
public void fly() {
	this.energylevel -= 50;
	System.out.println(" The sound of a bat taking off and decrease its energy by 50");
}
public void eatHumans() {
	this.energylevel += 25;
	System.out.println("So- well, never mind, just increase its energy by 25");
}
public void attackTown() {
	this.energylevel -=100;
	System.out.println("The sound of a town on fire and decrease its energy by 100.");
}
}