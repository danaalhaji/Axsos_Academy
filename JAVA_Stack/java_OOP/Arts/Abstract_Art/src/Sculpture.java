public class Sculpture extends Art{
	public String material;
	public Sculpture(String material, String title, String auther, String description) {
		this.auther = auther;
		this.description = description;
		this.material = material;
		this.title = title;
	}
	@Override
	void viewArt() {
		System.out.println("The type of this is art is Sculpture and made with" + this.material );
		
	}
}
