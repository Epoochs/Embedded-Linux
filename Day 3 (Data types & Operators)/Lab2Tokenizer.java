import java.util.StringTokenizer;

class Tokenizer
{
	public static void main(String[] args) {
        
        String str = args[0];
        StringTokenizer s = new StringTokenizer(str);
        
        while(s.hasMoreTokens())
        {
            System.out.println(s.nextToken("."));
        }
    }
}
