import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Info {
	int row;
	int col;
	int direction;
	int color;
	
	public Info(int row, int col, int direction, int color) {
		this.row = row;
		this.col = col;
		this.direction = direction;
		this.color = color;
	}
}

public class Main {
	static int r, c, direction;
	static int[][] board;
	static boolean[][] visited; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[19][19];
		visited = new boolean[19][19];
		
		StringTokenizer st;
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Info answer = solution();
		Info left = getSite();

		System.out.println(answer.color);
		if (answer.color != 0) System.out.println((left.row + 1) + " " + (left.col + 1));
	}
	
	private static Info getSite() {
		int row = 20, col = 20;
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (visited[i][j]) {
					if (col > j) {
						row = i;
						col = j;
					}
				}
			}
		}
		return new Info(row, col, 0, 0);
	}

	private static Info solution() {
		int direction = -1;
		int row = 0, col = 0;
		outer : for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] > 0) {
					int color = board[i][j];
					visited[i][j] = true;
					
					row = i;
					col = j;
					int count = 1;
					// 상하
					while (row - 1 >= 0) {
						if (board[row - 1][col] == color) {
							visited[row - 1][col]= true;
							count++;
							row--;
						} else {
							break;
						}
					}
					
					row = i;
					col = j;
					while (row + 1 <= 18) {
						if (board[row + 1][col] == color) {
							visited[row + 1][col]= true;
							count++;
							row++;
						} else {
							break;
						}
					}
					
					if (count == 5) {
						direction = 1;
						break outer;
					} else {
						visited = new boolean[19][19];
						visited[i][j] = true;
						count = 1;
					}
					
					// 좌우
					row = i;
					col = j;
					count = 1;
					while (col - 1 >= 0) {
						if (board[row][col - 1] == color) {
							visited[row][col - 1]= true;
							count++;
							col--;
						} else {
							break;
						}
					}
					
					row = i;
					col = j;
					while (col + 1 <= 18) {
						if (board[row][col + 1] == color) {
							visited[row][col + 1]= true;
							count++;
							col++;
						} else {
							break;
						}
					}
					
					if (count == 5) {
						direction = 3;
						break outer;
					} else {
						visited = new boolean[19][19];
						visited[i][j] = true;
						count = 1;
					}
					
					
					// 대각선 우상좌하
					row = i;
					col = j;
					count = 1;
					while (row - 1 >= 0 && col + 1 <= 18) {
						if (board[row - 1][col + 1] == color) {
							visited[row - 1][col + 1]= true;
							count++;
							row--;
							col++;
						} else {
							break;
						}
					}
					
					row = i;
					col = j;
					while (row + 1 <= 18 && col - 1 >= 0) {
						if (board[row + 1][col - 1] == color) {
							visited[row + 1][col - 1]= true;
							count++;
							row++;
							col--;
						} else {
							break;
						}
					}
					
					if (count == 5) {
						direction = 2;
						break outer;
					} else {
						visited = new boolean[19][19];
						visited[i][j] = true;
						count = 1;
					}
					
					// 대각선 좌상우하
					row = i;
					col = j;
					count = 1;
					while (row - 1 >= 0 && col - 1 >= 0) {
						if (board[row - 1][col - 1] == color) {
							visited[row - 1][col - 1]= true;
							row--;
							col--;
							count++;
						} else {
							break;
						}
					}
					
					row = i;
					col = j;
					while (row + 1 <= 18 && col + 1 <= 18) {
						if (board[row + 1][col + 1] == color) {
							visited[row + 1][col + 1]= true;
							row++;
							col++;
							count++;
						} else {
							break;
						}
					}
					
					if (count == 5) {
						direction = 4;
						break outer;
					} else {
						visited = new boolean[19][19];
						count = 1;
					}
					
				}
			}
		}
		
		return direction == -1 ? new Info(-1, -1, -1, 0) : new Info(row, col, direction, board[row][col]);
	}
}