package arc113;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		PrimeNumberGenerator pg = new PrimeNumberGenerator();
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();

		long result = 1;

		for(int i = 2; i <= k; i++){
			ArrayList<Num> list = new ArrayList<Num>();

			int n2 = i;

			while(true){
				boolean divided = false;

				int limit = (int)Math.sqrt(n2);
				for(int i1 = 2; i1 <= limit ; i1++){
					if(!pg.isPrime(i1)){
						continue;
					}

					if(n2%i1 == 0){
						n2 /= i1;
						if(list.isEmpty()){
							list.add(new Num(i1));
						}
						else{
							Num last = list.get(list.size() - 1);
							if(last.number == i1){
								last.count++;
							}
							else {
								list.add(new Num(i1));
							}
						}
						divided = true;
						break;
					}
				}

				if(!divided){
					if(list.isEmpty()){
						list.add(new Num(n2));
					}
					else{
						Num last = list.get(list.size() - 1);
						if(last.number == n2){
							last.count++;
						}
						else {
							list.add(new Num(n2));
					}
				}
					break;
				}
			}

			long tmp = 1;
			for(int i1 = 0; i1 < list.size() ; i1++){
				int l = list.get(i1).count;

				tmp *= (long)(l + 1)*(l + 2)/2;
			}

			result += tmp;
		}

		System.out.println(result);
	}

}

class Num {
	int number;
	int count;

	Num(int number){
		this.number = number;
		count = 1;
	}
}
class PrimeNumberGenerator {
    private boolean[] isPrime= new boolean[200001];

    public PrimeNumberGenerator() {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;

        int limit = (int)Math.sqrt(isPrime.length);
        for(int i = 3; i <= limit; i+=2){
            if(isPrime[i] == false){
                continue;
            }

            for(int j = i * 2; j <= isPrime.length - 1; j += i){
                isPrime[j] = false;
            }
        }
    }

    public boolean isPrime(int index){
        if(index % 2 == 0 && index != 2){
            return false;
        }
        return isPrime[index];
    }
}