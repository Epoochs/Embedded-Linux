class MyShapePatternManual
{
	public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        String ast = "*";
        String space = " ";

        int k1 = 1;
        int k2 = (2 * n) + 1;
        int row = 1;

        for (int i = 1; i <= n*(2*n + 1); i++)
        {            
            if(i < k1 + 1)
            {
                System.out.print(ast);
            }
            else
            {
            	System.out.print(space);
            }

            if(i >= k2)
            {
            	System.out.print(ast);
            }

            if(i % (2*n + 1) == 0)
            {
                row++;
                k1 = ((2*n+1) * (row - 1)) + row;
                k2 = ((2*n+1) * row) - (row - 1);
                System.out.println("");
            }
        }
    }
}class MySecondPattern
{
	public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        String ast = "*";
        String space = " ";

        int k1 = 1;
        int k2 = (2 * n) + 1;
        int row = 1;

        for (int i = 1; i <= n*n; i++)
        {            
            if(i < k1 + 1)
            {
                System.out.print(ast);
            }
            else
            {
            	System.out.print(space);
            }

            if(i >= k2)
            {
            	System.out.print(ast);
            }

            if(i % (2*n + 1) == 0)
            {
                row++;
                k1 = ((2*n+1) * (row - 1)) + row;
                k2 = ((2*n+1) * row) - (row - 1);
                System.out.println("");
            }
        }
    }
}