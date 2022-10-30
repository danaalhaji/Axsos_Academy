import java.util.ArrayList;
import  java.util.Random;
public class AbstractArt_Test  {
	public static void main(String[] args) {
		Random random = new Random();
		Painting p1 = new Painting("Oil", "Paint", "Dana", "No");
		Painting p2 = new Painting("Acrylic", "Paint", "Ahmad", "No");
		Painting p3 = new Painting("Watercolor", "Paint", "Ahmad", "No");
		p1.viewArt();
		p2.viewArt();
		p3.viewArt();
		Sculpture s1 =  new Sculpture (" Marble", "Paint", "Dana", "No");
		Sculpture s2 =  new Sculpture (" Bronze", "Paint", "Dana", "No");
		s1.viewArt();
		s2.viewArt();
		ArrayList<Art> museum = new ArrayList<Art> ();
		museum.add(p1);
		museum.add(p2);
		museum.add(p3);
		museum.add(s1);
		museum.add(s2);
		for(Art k : museum) {
			System.out.println("The Art is:");
			k.viewArt();
		}
		for(int i = 0 ; i < museum.size(); i++) {
			int t = random.nextInt(museum.size());
			Art a = museum.get(t);
			System.out.println("The random art is");
			a.viewArt();
		}
	}
}
