class Args
{
	public static void main(String[]args)
	{
		// Characters need to be parsed
		
		int res = 0;
		int num1 = 0;
		int num2 = 0;
		
		if(args.length == 3)
		{
			if(Character.isDigit(args[0].charAt(0)))
			{
				num1 = Integer.parseInt(args[0]);
			}
			else
			{
				System.out.println("Operand 1 is not a digit");
				System.exit(1);
			}
			
			if(Character.isDigit(args[2].charAt(0)))
			{
				num2 = Integer.parseInt(args[2]);
			}
			else
			{
				System.out.println("Operand 2 is not a digit");
				System.exit(2);
			}
		
			switch(args[1])
			{
			
			case "+":
			res = num1 + num2;
			break;
			
			case "-":
			res = num1 - num2;
			break;
			
			case "x":
			res = num1 * num2;
			break;
			
			case "/":
			
			if(num2 != 0)
			{
			res = num1 / num2;
			}
			else
			{
			System.out.println("You cannot divide by zero");
			System.exit(3);
			}
			break;
			
			default:
			System.out.println("Wrong Operator");
			break;
			}	
		}
		else
		{
		System.out.println("Missing Parameter");
		System.exit(4);
		}
		
		System.out.println("Result is: " + res);
	}
}
