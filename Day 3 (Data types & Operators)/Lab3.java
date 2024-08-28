class ShapePatern
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        String ast = "*";
        String space = " ";

        for(int i = 1; i <= n; i++)
        {
            // First pattern and the second pattern are implemented in this System.out
            System.out.print(ast.repeat(i) + space.repeat(2*(n + 1 - i) - 1));

            // Third pattern implementation
            System.err.print((ast + space).repeat(i));

            // Printing new line
            System.err.println("");
        }
    }
}