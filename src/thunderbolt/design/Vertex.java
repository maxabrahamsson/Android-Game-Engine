package thunderbolt.design;

public class Vertex {
	private Position p;
	private Color c;
	public Vertex(Position p,Color c)
	{
		this.p=p;
		this.c=c;
	}
	public Position getPosition()
	{
		return this.p;
	}
	public Color getColor()
	{
		return this.c;
	}
}
