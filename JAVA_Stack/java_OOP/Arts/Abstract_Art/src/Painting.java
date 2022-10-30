public class Painting extends Art {
	public String paintType;
	public Painting(String type, String title, String auther, String description) {
		this.paintType = type;
		this.auther = auther;
		this.title =title;
		this.description = description;
		
	}
	@Override
	void viewArt() {
		System.out.println("The paint Type is" + paintType);
	}
}
