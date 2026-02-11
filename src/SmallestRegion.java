import java.io.*;
import java.util.*;

public class SmallestRegion {
	static class Rect{ int x1,y1,x2,y2; Rect(int a,int b,int c,int d){x1=a;y1=b;x2=c;y2=d;} }

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = readInt(br);
		Rect[] rects = new Rect[n];
		for(int i=0;i<n;i++){
			int x1 = readInt(br), y1 = readInt(br), x2 = readInt(br), y2 = readInt(br);
			rects[i] = new Rect(x1,y1,x2,y2);
		}
		int ox1 = readInt(br), oy1 = readInt(br), ox2 = readInt(br), oy2 = readInt(br);

		List<Integer> xs = new ArrayList<>();
		List<Integer> ys = new ArrayList<>();
		xs.add(ox1); xs.add(ox2);
		ys.add(oy1); ys.add(oy2);

		for(int x = Math.min(ox1, ox2)+1; x < Math.max(ox1, ox2); x++){
			if(isAllowedVertical(x, rects)) xs.add(x);
		}
		for(int y = Math.min(oy1, oy2)+1; y < Math.max(oy1, oy2); y++){
			if(isAllowedHorizontal(y, rects)) ys.add(y);
		}

		Collections.sort(xs);
		Collections.sort(ys);

		int minDx = Integer.MAX_VALUE;
		for(int i=1;i<xs.size();i++) minDx = Math.min(minDx, Math.abs(xs.get(i)-xs.get(i-1)));
		int minDy = Integer.MAX_VALUE;
		for(int i=1;i<ys.size();i++) minDy = Math.min(minDy, Math.abs(ys.get(i)-ys.get(i-1)));

		long area = 1L * minDx * minDy;
		System.out.print(area);
	}

	static boolean isAllowedVertical(int x, Rect[] rects){
		for(Rect r: rects){ if(r.x1 < x && x < r.x2) return false; }
		return true;
	}
	static boolean isAllowedHorizontal(int y, Rect[] rects){
		for(Rect r: rects){ if(r.y1 < y && y < r.y2) return false; }
		return true;
	}

	static int readInt(BufferedReader br) throws IOException{
		int c; int s=1; int v=0; boolean started=false;
		while(true){
			br.mark(1);
			c = br.read();
			if(c==-1) return v*s;
			if(c=='-'){ s=-1; started=true; break; }
			if(c>='0'&&c<='9'){ v=c-'0'; started=true; break; }
		}
		while(true){
			br.mark(1);
			c = br.read();
			if(c<'0'||c>'9'){ br.reset(); break; }
			v = v*10 + (c-'0');
		}
		return v*s;
	}
}
