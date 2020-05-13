package abc066;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {

	  public static void main(String[] args) throws Exception {
	        // Here your code !
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String[] strArray = br.readLine().split(" ");

	        //int[] price = new int[3];

	        int sum = 0;
	        int maxPrice = 0;
	        for(int i = 0; i < 3; i++){
	            int tmp = Integer.parseInt(strArray[i]);
	            sum += tmp;

	            if(tmp > maxPrice){
	                maxPrice = tmp;
	            }
	        }

	        System.out.println(sum - maxPrice);
	    }
	}