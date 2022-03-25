package sw;

public class toss_test5 {
	static String[][] grids = 
			{{".....",".XXX.",".X.X.",".XXX.","....."},
			{"XXXXX","XXXXX","XXX.X","XXX.X","XXXXX"},
			{
				"XXXXX",
				"X...X",
				"X.X.X",
				"X...X",
				"XXXXX"},
			{
					"....X",
					".....",
					"XXX..",
					"X.X..",
					"XXX.."},
			{".......","XXX.XXX","X.X.X.X","XXX.XXX","......."},
			{"XXXXX","XX.XX","X...X","XX.XX","XXXXX"}};
	static boolean[] answer = new boolean[grids.length];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int b_x1, b_x2, b_x3, b_x4;
	static int b_y1, b_y2, b_y3, b_y4;
	public static void main(String[] args) {
		for (int i = 0; i < grids.length; i++) {
			boolean check = black(grids[i]);
		}
		int w_x1 = 0, w_x2 = 0;
		int w_y1 = 0, w_y2 = 0;
	}
	private static boolean black(String[] grid) {
		boolean[][] visit = new boolean[grid.length][grid[0].length()];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				if(grid[i].charAt(j) == 'X') {
					return dfs(i, j, grid);
				}
			}
		}
		return false;
	}
	private static boolean dfs(int y, int x, String[] grid) {
		b_x1 = x; b_y1 = y;
		int xx = x;
		int yy = y;
		for (int i = 0; i < 3; i++) {
			
			while(true) {
				int nx = xx + dx[i];
				int ny = yy + dy[i];
				if(nx < 0 || ny < 0 || nx >= grid[0].length() || ny >= grid.length) break;
				if(grid[ny].charAt(nx) == '.') break;
				xx = nx;
				yy = ny;
			}
			if(i == 0) {
				b_x2 = xx;
				b_y2 = yy;
			}else if (i == 1) {
				b_x3 = xx;
				b_y3 = yy;
			}else if (i == 2) {
				b_x4 = xx;
				b_y4 = yy;
			}
		}
		if( b_x1 != b_x4 || b_x2 != b_x3 ) {
			System.out.println(b_x1 + " " + b_x2 + " " + b_x3 + " " + b_x4);
			return false;
		}else if (b_y1 != b_y2 || b_y3 != b_y4) {
			return false;
		}else if (b_x1 == b_x2 && b_x3 == b_x4) {
			return false;
		}
		System.out.println(b_x1 + " " + b_x2 + " " + b_x3 + " " + b_x4);
		return true;
	}

}
