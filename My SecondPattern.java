Class MySecondPattern
{
	public static void main(String[]args)
	{
		int n = Integer.parseInt(args[0]);
        String ast = "*";
        String space = " ";

        int k = 1;
        int k2 = 0;
        int row = 1;

        for(int i = 1; i <= n*n; i++)
        {
        	if(i < k)
        	{
        		System.out.print(" ");
        	}
        	else 
        	{
        		System.out.print("* ");
        	}

        	if(i % n == 0)
        	{
        		System.out.println("");
        	}
        }
	}
}