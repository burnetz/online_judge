package vol16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlmostIdenticalProgram {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String input1 = br.readLine();

			if(input1.equals(".")){
				break;
			}

			String input2 = br.readLine();

			if(input1.equals(input2)){
				System.out.println("IDENTICAL");
			}
			//全く同じか少し違う
			else {
				//""が連続しても対応できるようオプション指定
				String[] strArray1 = input1.split("\"", -1);
				String[] strArray2 = input2.split("\"", -1);

				if(strArray1.length != strArray2.length){
					System.out.println("DIFFERENT");
					continue;
				}
				int diffStr = 0;
				int diffSentence = 0;

				for(int i = 0; i < strArray1.length; i++){
					if(!strArray1[i].equals(strArray2[i])){
						if(i%2 == 0){
							diffSentence++;
							break;
						}
						else {
							diffStr++;
						}
					}
				}

				if(diffSentence == 0 && diffStr == 1){
					System.out.println("CLOSE");
				}
				else {
					System.out.println("DIFFERENT");
				}
			}

		}
	}

}
