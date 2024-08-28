class Complex
{
	private int real;
	private int img;

	private static int sumReal;
	private static int sumImg;

	public Complex()
	{
		real = 0;
		img = 0;
	}

	public Complex(int r, int i)
	{
		real = r;
		img = i;
	}

	public void setReal(int r)
	{
		real = r;
	}
	public void setImg(int i)
	{
		img = i;
	}

	public int getReal()
	{
		return real;
	}

	public int getImg()
	{
		return img;
	}

	public void sumCom()
	{
		sumReal += real;
		sumImg += img;
	}

	public void subCom()
	{
		sumReal -= real;
		sumImg -= img;
	}

	public static int getSumReal()
	{
		return sumReal;
	}

	public static int getSumImg()
	{
		return sumImg;
	}
}


class MyComplex
{
	public static void main(String[]args)
	{
		Complex cx1 = new Complex(3,4);
		cx1.sumCom();

		Complex cx2 = new Complex(2,1);
		cx2.sumCom();

		System.out.println("Complex number: " + Complex.getSumReal() + " + " + Complex.getSumImg() + "j");
	}
}
