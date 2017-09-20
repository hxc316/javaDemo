import java.util.StringTokenizer;


public class StringTokeTest {
	
	public static void main(String[] args) {
		String a = "a,b,c,d";
		StringTokenizer tokenizer = new StringTokenizer(a,",");
		while(tokenizer.hasMoreElements()){
			String next = tokenizer.nextToken();
		}
		
	}

}
