package thunderbolt.design;

public class Color {
	private float r,g,b,a;
	public Color(float r,float g,float b)
	{
		this.r=r;
		this.g=g;
		this.b=b;
		this.a=100;
	}
	public Color(float r,float g,float b,float a)
	{
		this.r=r;
		this.g=g;
		this.b=b;
		this.a=a;
	}
	public float getR()
	{
		return r;
	}
	public float getG()
	{
		return g;
	}
	public float getB()
	{
		return b;
	}
	public float getA()
	{
		return a;
	}
}
