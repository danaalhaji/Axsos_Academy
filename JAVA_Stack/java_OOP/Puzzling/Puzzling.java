import java.util.Random;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Puzzling {
    public int[] getTenRolls(){
        int[] randArray;
        Random randomMachine = new Random();
        randArray = new int[10];
        for(int i = 0 ; i < 10 ; i++){
            randArray[i] = randomMachine.nextInt(20)+1;
        }
        return randArray;
    }
    public char getRandomLetter(){
        Random charLetter = new Random();
        Random randomIndex = new Random();
        char[] randLetter;
        randLetter = new char [26];
        for(int i = 0 ; i < 26 ; i++){
            randLetter[i] = (char)(charLetter.nextInt(26)+'a');
        }
        return randLetter[randomIndex.nextInt(26)];
    }
    public String generatePassword(){
        String passwordRan = "";
        for (int i = 0 ; i < 8 ;i++){
            passwordRan += Character.toString(this.getRandomLetter()) ;
        }
        return passwordRan ;
    }
    // public void shuffleArray(List arr){
    //     Random randomIndex = new Random();
    //     Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7 };

	// 	List<Integer> intList = Arrays.asList(intArray);

	// 	Collections.shuffle(intList);

	// 	intList.toArray(intArray);

	// 	System.out.println(Arrays.toString(intArray));
    // }
}