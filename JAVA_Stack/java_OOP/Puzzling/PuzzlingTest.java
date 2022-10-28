import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PuzzlingTest {
    public static void main(String[] args){
        Puzzling test = new Puzzling();
        int[] arrayRandom ;
        char randLetter;
        String passwordRandom;
        arrayRandom = new int [10];
        arrayRandom = test.getTenRolls();
        randLetter = test.getRandomLetter();
        passwordRandom = test.generatePassword();

        // ------Type the random integer array -------------
        for (int i = 0 ; i< 10 ; i++){
            System.out.println(arrayRandom[i]);
        }

        // -----Type the random character-------------------
        System.out.println("This is a random character from our method : "+randLetter);

        // ------Type the generated passowrd------------------
        System.out.println("This is a generated passowrd: " + passwordRandom);
    //     List<integer> arr = Arrays.asList (1 , 2 , 5 , 6 , 8);
    //     test.shuffleArray(arr);
    // }
    
}
}