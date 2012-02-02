package thunderbolt.design;

public class Circle extends Polygon {
	private static final float M_PI = 3.14159f;
	public Circle(Position p,Color c,float radius)
	{
		super(20);
		for(Integer i=0; i<20; i++)
		{
			super.addVertex(
					new Vertex(
					new Position(
							p.getX()+(float)Math.cos(i*(360/20)*M_PI/180)*radius, 
							p.getY()+(float) Math.sin(i*(360/20)*M_PI/180)*radius,
							0),
					c));
		}
	}
}
