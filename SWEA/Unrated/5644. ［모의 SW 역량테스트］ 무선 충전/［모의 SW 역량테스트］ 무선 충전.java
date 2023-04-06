import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int m, btCnt;
	
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	static int[] aPath, bPath, aNow, bNow;
	static int[][] bc;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		aNow = new int[2];
		bNow = new int[2];
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			btCnt = Integer.parseInt(st.nextToken());
			aPath = new int[m + 1];
			bPath = new int[m + 1];
			
			aNow[0] = aNow[1] = 1;
			bNow[0] = bNow[1] = 10;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				aPath[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				bPath[i] = Integer.parseInt(st.nextToken());
			}
			
			bc = new int[btCnt][4];
			for (int i = 0; i < btCnt; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					bc[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#" + tc + " " + move());
		}
	}
	
	private static int move() {
		int sum = 0;
		for (int i = 0; i <= m; i++) {
			aNow[0] += dx[aPath[i]];
			aNow[1] += dy[aPath[i]];
			
			bNow[0] += dx[bPath[i]];
			bNow[1] += dy[bPath[i]];
			
			sum += getMax();
		}
		
		return sum;
	}
	
	private static int getMax() {
		int max = 0;
		for (int a = 0; a < btCnt; a++) {
			for (int b = 0; b < btCnt; b++) {
				int sum = 0;
				int ap = check(a, aNow[0], aNow[1]);
				int bp = check(b, bNow[0], bNow[1]);
				
				if (a != b) {
					sum = ap + bp;
				} else {
					sum = ap < bp ? bp : ap;
				}
				
				max = max > sum ? max : sum;
			}
		}
		
		return max;
	}
	
	private static int check(int a, int x, int y) {
		return Math.abs(bc[a][0] - x) + Math.abs(bc[a][1] - y) <= bc[a][2] ? bc[a][3] : 0;
	}
	
}