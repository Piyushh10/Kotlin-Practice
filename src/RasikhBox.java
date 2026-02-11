import java.util.*;

public class RasikhBox{
    static char[][] rotateRight(char[][] box){
        int m = box.length, n=box[0].length;
        char[][] res = new char[n][m];
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                res[j][m-1-i]=box[i][j];
            }
        }
        return res;
    }
    static char[][] rotateLeft(char[][] box){
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                res[n-1-j][i]=box[i][j];
            }
        }
        return res;
    }
    static void applyGravity(char[][] box){
        int m = box.length;
        int n = box[0].length;
        for(int j = 0; j<n;j++){
            int empty = m-1;
            for(int i = m-1; i>=0;i--){
                if(box[i][j]=='*'){
                    box[i][j]='.';
                    box[empty][j]='*';
                    empty--;
                }
            }
        }
    }
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		char[][] box = new char[m][n];
		for(int i = 0; i < m; i++){
			String line = sc.nextLine();
			while(line.trim().isEmpty()) line = sc.nextLine();
			line = line.replace(" ", ""); 
			box[i] = line.toCharArray();
		}

		int k = sc.nextInt();
		sc.nextLine();

		applyGravity(box);

		for(int instr = 0; instr < k; instr++){
			String dir = sc.nextLine().trim();
			if(dir.equals("right")){
				box = rotateRight(box);
			}else{
				box = rotateLeft(box);
			}
			applyGravity(box);
		}

		for(int i = 0; i < box.length; i++){
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < box[0].length; j++){
				if(j > 0) sb.append(' ');
				sb.append(box[i][j]);
			}
			System.out.println(sb.toString());
		}
	}
}