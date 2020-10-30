package sheepDrawing;

public class Utils{
	static String insSpace(int n) {
		String s = "";
		for(int i = 0; i < n; i ++) {
			s+="   ";
		}
		return s;
	}
	
	static void log(Object s) {
		System.out.println(s);
	}

}
