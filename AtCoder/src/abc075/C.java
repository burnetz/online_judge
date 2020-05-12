package abc075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);

		Line[] lines = new Line[m];

		for(int i = 0; i < m; i++){
			tmpArray = br.readLine().split(" ");
			lines[i] = new Line(Integer.parseInt(tmpArray[0]), Integer.parseInt(tmpArray[1]));

		}

		int[] visited = new int[n + 1];
		int[] finished = new int[n + 1];

		int[][] matrix = new int[n + 1][n + 1];

		int bridge = 0;
		for(int i = 0; i < m; i++){
			initMatrix(matrix, lines, n, i);
			Arrays.fill(visited, 0);
			Arrays.fill(finished, 0);

			dfs(matrix, visited, finished, 1, 0);

			for(int j = 1; j <= n ; j++){
				if(visited[j] == 0){
					bridge++;
					break;
				}
			}
		}

		System.out.println(bridge);
	}

	static void initMatrix(int[][] matrix, Line[] lines, int n, int skip){
		for(int i = 0; i <= n; i++){
			Arrays.fill(matrix[i], 0);
		}

		for(int i = 0; i < lines.length ; i++){
			if(i == skip){
				continue;
			}

			matrix[lines[i].start][lines[i].end] = 1;
			matrix[lines[i].end][lines[i].start] = 1;
		}
	}
	static int dfs (int[][] matrix, int[] visited, int[] finished, int v, int time){
        time++;
        visited[v] = time;

        int tmpTime = time;
        for(int i = 1; i <= matrix[v].length - 1 ; i++){
            if(matrix[v][i] == 1 && visited[i] <= 0){
                tmpTime = dfs(matrix, visited, finished, i, tmpTime);
            }
        }

        finished[v] = tmpTime + 1;

        return tmpTime + 1;
    }
}

class Line{
	int start;
	int end;

	public Line(int start, int end){
		this.start = start;
		this.end = end;
	}
}