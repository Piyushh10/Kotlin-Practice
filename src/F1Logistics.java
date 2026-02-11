import java.io.*;
import java.util.*;

public class F1Logistics {
    static class Race{
        int x, y, d;
        Race(int x, int y, int d){ this.x = x; this.y = y; this.d = d; }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = readInt(br);
        Race[] races = new Race[n];
        for(int i = 0; i < n; i++){
            int x = readInt(br);
            int y = readInt(br);
            int d = readInt(br);
            races[i] = new Race(x, y, d);
        }
        boolean[][] g = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(races[j].d <= races[i].d) continue;
                int dist = Math.abs(races[i].x - races[j].x) + Math.abs(races[i].y - races[j].y);
                if(races[j].d - races[i].d >= dist) g[i][j] = true;
            }
        }
        int[] matchR = new int[n];
        Arrays.fill(matchR, -1);
        int maxMatching = 0;
        for(int u = 0; u < n; u++){
            boolean[] seen = new boolean[n];
            if(dfs(u, g, seen, matchR)) maxMatching++;
        }

        int minCars = n - maxMatching;
        System.out.print(minCars);
    }
    static boolean dfs(int u, boolean[][] g, boolean[] seen, int[] matchR){
        for(int v = 0; v < g.length; v++){
            if(!g[u][v] || seen[v]) continue;
            seen[v] = true;
            if(matchR[v] == -1 || dfs(matchR[v], g, seen, matchR)){
                matchR[v] = u;
                return true;
            }
        }
        return false;
    }
    static int readInt(BufferedReader br) throws IOException{
        int c;
        int sign = 1;
        int val = 0;
        while(true){
            br.mark(1);
            c = br.read();
            if(c == -1) return val;
            if(c == '-') { sign = -1; break; }
            if(c >= '0' && c <= '9') { val = c - '0'; break; }
        }
        while(true){
            br.mark(1);
            c = br.read();
            if(c < '0' || c > '9') { br.reset(); break; }
            val = val * 10 + (c - '0');
        }
        return val * sign;
    }
}