import java.util.HashMap;
import java.util.Set;
public class Hashmatique{
    public static void main(String[] args){
        HashMap<String , String> trackList = new HashMap<String , String>();
        trackList.put("Unholy" , "Sam Smith");
        trackList.put("Sebooh" , " Amr Mostafa");
        trackList.put("CalmDown" , "Selena Gomez");
        trackList.put("BellaBella" , " Naika");
        System.out.println(trackList.get("Unholy"));
        Set<String> titles = trackList.keySet();
        for(String title : titles ){
            System.out.println(title + " - " + trackList.get(title));
        }
    }
}