import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * main
 */
public class Method2 {
    public static void main(String[] args) {
        
        // initiating variables
        ArrayList<Integer> list_of_prime = new ArrayList<Integer>();
        list_of_prime.add(2);
        list_of_prime.add(3);
        list_of_prime.add(5);
        list_of_prime.add(7);

        int curr_number = 11;

        // timer for while
        long t = System.currentTimeMillis();
        long end = t + 1000*30;

        
        while(System.currentTimeMillis() < end){
            Boolean is_prime = true;
            int loop_times = binarySearch(curr_number, list_of_prime);
            if(loop_times == -1) is_prime = false; 
            for(int i = 0; i < loop_times ; i++){
                if(curr_number % list_of_prime.get(i) == 0){
                    is_prime = false;
                }
            }
            if(is_prime) {
                list_of_prime.add(curr_number);
            }
            curr_number+=2;
        }
        
        // create file and write file
        File primes = new File("result2.txt");
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
    
    // finding the index of the smallest number that is bigger than sqrt(n) and checking if sqrt(n) is an integer.
    static int binarySearch(int n, ArrayList<Integer> list){
        Double root = Math.sqrt(n);
        if( root % 1 == 0) return -1;
        boolean bool = true;
        int start = 0;
        int end = list.size()-1;
        int middle = (start + end)/2;
        for(int i = 0; i < list.size(); i++){
            if(list.get(middle) > root){
                if(list.get(middle - 1) < root){
                    return middle;
                }
                end = middle - 1;
            } else{
                start = middle + 1;
            }
            middle = (start + end)/2;
        }
        return -1;
    }
}