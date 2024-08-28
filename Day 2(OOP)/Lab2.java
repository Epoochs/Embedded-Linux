abstract class Shape
{
	private int dim1;

	public Shape()
	{
	}

	public Shape(int dim1)
	{
		this.dim1 = dim1;
	}

	public void setDim1(int l)
	{
		dim1 = l;
	}

	public int getDim1()
	{
		return dim1;
	}

	public abstract double calcArea();


}

class Circle extends Shape
{
	public Circle()
	{
	}

	public Circle(int l)
	{
		super(l);
	}
	@Override
	public double calcArea()
	{
		return (3.14 * super.getDim1() * super.getDim1());
	}
}

class Triangle extends Shape
{
	private int dim2;

	public Triangle()
	{
	}

	public Triangle(int l1, int l2)
	{
		super(l1);
		dim2 = l2;
	}
	@Override
	public double calcArea()
	{
		return (super.getDim1() * dim2 * 0.5);
	}

	public void setDim2(int l2)
	{
		dim2 = l2;
	}

	public int getDim2()
	{
		return dim2;
	}
}

class Rectangle extends Shape
{
	private int dim2;

	public Rectangle()
	{
	}

	public Rectangle(int l1, int l2)
	{
		super(l1);
		dim2 = l2;
	}
	@Override
	public double calcArea()
	{
		return (super.getDim1() * dim2);
	}

	public void setDim2(int l2)
	{
		dim2 = l2;
	}

	public int getDim2()
	{
		return dim2;
	}
}


class MyShape
{
	public static  double CalcArea(Shape sh)
	{
		return sh.calcArea();
	}

	public static double SumAreas(double a1, double a2, double a3) {
		return (a1+a2+a3);
	}
	public static void main(String[]args)
	{
		Shape circle = new Circle(5);
		Shape rectangle = new Rectangle(5, 10);
		Shape triangle = new Triangle(5, 5);



		 System.out.println("Sum of Circle = " + CalcArea(circle) + '\n' + "Sum of Triangle = " + CalcArea(triangle) + '\n' + "Sum of Rectangle = " + CalcArea(rectangle) + "   Sum of all area: " + SumAreas(CalcArea(triangle), CalcArea(rectangle), CalcArea(circle)));
	}
}