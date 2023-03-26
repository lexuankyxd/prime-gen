import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * main
 */
public class Method1 {
    public static void main(String[] args) {
        
        // initiating variables
        ArrayList<Integer> list_of_prime = new ArrayList<Integer>();
        int curr_number = 2;

        // timer for while
        long t = System.currentTimeMillis();
        long end = t + 1000*30;

        
        while(System.currentTimeMillis() < end){
            Boolean is_prime = true;
            for(int i = 0; i < list_of_prime.size(); i++){
                if(curr_number % list_of_prime.get(i) == 0){
                    is_prime = false;
                }
            }
            if(is_prime) {
                list_of_prime.add(curr_number);
            }
            curr_number++;
        }
        
        // create file and write file
        File primes = new File("result1.txt");
        try {
            PrintWriter printer = new PrintWriter(primes);
            for(int i = 0; i < list_of_prime.size(); i++){
                printer.println(list_of_prime.get(i));
            }
            printer.close();
    
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    
}