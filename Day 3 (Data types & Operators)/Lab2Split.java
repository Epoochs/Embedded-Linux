class Split
{
	public static void main(String[] args) {
        String str = args[0];
        String[] str1 = str.split("[.]");
        
        for (String s : str1)
        {
            System.out.println(s);
        }
    }
}
