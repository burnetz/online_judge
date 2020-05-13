package abc064;

import java.util.Scanner;

public class C {

    public static void main(String[] args)  {
        // Here your code !
    	Scanner sc = new Scanner(System.in);

    	int rank[] = new int[9];
    	int n = sc.nextInt();

    	for(int i = 0; i < n; i++){
    		int rate = sc.nextInt();

    		if(rate <= 399){
    			rank[0]++;
    		}
    		else if(rate <= 799){
    			rank[1]++;
    		}
    		else if(rate <= 1199){
    			rank[2]++;
    		}
    		else if(rate <= 1599){
    			rank[3]++;
    		}
    		else if(rate <= 1999){
    			rank[4]++;
    		}
    		else if(rate <= 2399){
    			rank[5]++;
    		}
    		else if(rate <= 2799){
    			rank[6]++;
    		}
    		else if(rate <= 3199){
    			rank[7]++;
    		}
    		else {
    			rank[8]++;
    		}
    	}

    	int color = 0;

    	for(int i = 0; i < 8; i++){
    		if(rank[i] > 0){
    			color++;
    		}
    	}

    	System.out.println(Math.max(color, 1) + " " + (color + rank[8]));
    }
}