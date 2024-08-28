class Parent
{
	private int num1;
	private int num2;

	public Parent(int x, int y)
	{
		num1 = x;
		num2 = y;
	}

	public Parent()
	{
		num1 = 0;
		num2 = 0;
	}

	public void setNum1(int x)
	{
		num1 = x;
	}
	public void setNum2(int y)
	{
		num2 = y;
	}

	public int getNum1()
	{
		return num1;
	}
	public int getNum2()
	{
		return num2;
	}



	public int sum()
	{
		return num1 + num2;
	}
}

class Child extends Parent
{
	private int num3;

	public Child()
	{
		super(0,0);
		num3 = 0;
	}

	public Child(int x, int y, int z)
	{
		super(x,y);
		num3 = z;
	}

	public void setNum3(int z)
	{
		num3 = z;
	}
	@Override
	public int sum()
	{
		return super.sum() + num3;
	}
}


class Main{

	public static void main(String[]args)
	{
		Child ch = new Child(1,2,3);
		System.out.println("Sum of the numbers: " + ch.sum());
	}
}
