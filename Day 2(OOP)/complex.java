class Complex
{
	private int real;
	private int img;

	private int sumReal;
	private int sumImg;

	public Complex()
	{
		real = 0;
		img = 0;
		sumImg = 0;
		sumReal = 0;
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

	public void sumCom(Complex c1, Complex c2)
	{
		sumReal = c1.real + c2.real;
		sumImg = c2.img + c1.img;
	}

	public void subCom(Complex c1, Complex c2)
	{
		sumReal = c1.real - c2.real;
		sumImg = c1.img - c2.img;
	}

	public int getSumReal()
	{
		return sumReal;
	}

	public int getSumImg()
	{
		return sumImg;
	}

	public void print()
	{
		if(sumReal < 0 || sumImg < 0)
		{
			System.out.print(sumReal + " - " + Math.abs(sumImg) + "j");
		}
		else
		{
			System.out.print(sumReal + " + " + sumImg + "j");
		}
	}
}


class MyComplex
{
	public static void main(String[]args)
	{
		Complex cx1 = new Complex(3,4);
		Complex cx2 = new Complex(2,9);

		Complex sumCom = new Complex();
		Complex subCom = new Complex();

		sumCom.sumCom(cx1,cx2);
		subCom.subCom(cx1, cx2);

		sumCom.print();
		System.out.println("");
		subCom.print();
	}
}
