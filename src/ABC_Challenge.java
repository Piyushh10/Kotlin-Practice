import java.io.*;
import java.util.*;

public class ABC_Challenge {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = readInt(br);
        char[] s = new char[n];
        int filled = 0;
        while(filled < n){
            String line = br.readLine();
            if(line == null) break;
            line = line.trim();
            if(line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            for(String p : parts){
                if(p.isEmpty()) continue;
                s[filled++] = p.charAt(0);
                if(filled == n) break;
            }
        }
        List<Integer> fixed = new ArrayList<>();
        String lineFixed = null;
        while(true){
            lineFixed = br.readLine();
            if(lineFixed == null) break;
            lineFixed = lineFixed.trim();
            if(!lineFixed.isEmpty()) break;
        }
        if(lineFixed != null && !lineFixed.isEmpty()){
            String[] ps = lineFixed.split("\\s+");
            for(String p : ps){ if(!p.isEmpty()) fixed.add(Integer.parseInt(p)); }
        }

        int cntA = 0, cntB = 0, cntC = 0;
        for(char ch : s){ if(ch=='A') cntA++; else if(ch=='B') cntB++; else cntC++; }

        char[][] perms = {
                {'A','B','C'}, {'A','C','B'}, {'B','A','C'},
                {'B','C','A'}, {'C','A','B'}, {'C','B','A'}
        };

        int bestLcs = -1;
        for(char[] order : perms){
            char[] target = new char[n];
            int idx = 0;
            int[] len = new int[3];
            len[map(order[0])] = (order[0]=='A'?cntA:order[0]=='B'?cntB:cntC);
            len[map(order[1])] = (order[1]=='A'?cntA:order[1]=='B'?cntB:cntC);
            len[map(order[2])] = (order[2]=='A'?cntA:order[2]=='B'?cntB:cntC);
            for(int k=0;k<3;k++){
                char ch = order[k];
                int rep = (ch=='A'?cntA:ch=='B'?cntB:cntC);
                for(int t=0;t<rep;t++) target[idx++] = ch;
            }

            boolean ok = true;
            for(int p : fixed){
                int i = p-1; if(i<0||i>=n) continue;
                if(target[i] != s[i]){ ok = false; break; }
            }
            if(!ok) continue;

            int lcs = lcsLength(s, target);
            bestLcs = Math.max(bestLcs, lcs);
        }

        if(bestLcs < 0){
            System.out.print("Impossible");
        }else{
            System.out.print(n - bestLcs);
        }
    }

    static int map(char c){ return c=='A'?0:(c=='B'?1:2); }

    static int lcsLength(char[] a, char[] b){
        int n = a.length, m = b.length;
        int[] dp = new int[m+1];
        for(int i=1;i<=n;i++){
            int prev = 0;
            for(int j=1;j<=m;j++){
                int temp = dp[j];
                if(a[i-1]==b[j-1]) dp[j] = prev + 1; else dp[j] = Math.max(dp[j], dp[j-1]);
                prev = temp;
            }
        }
        return dp[m];
    }

    static int readInt(BufferedReader br) throws IOException{
        int c, sign = 1, val = 0; boolean started=false;
        while(true){
            br.mark(1);
            c = br.read();
            if(c == -1) return val;
            if(c == '-') { sign = -1; started=true; break; }
            if(c >= '0' && c <= '9') { val = c - '0'; started=true; break; }
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
