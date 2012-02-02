package thunderbolt.design;


import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;


public class Polygon {
	public int n;
	protected Vertex[] Vertices;
	private int nvertices;
	
	protected FloatBuffer vertexBuffer;
	protected FloatBuffer colorBuffer;
	
	public Polygon(int nvertices)
	{
		n=0;
		this.nvertices=nvertices;
		this.Vertices=new Vertex[nvertices];
	}
	public void yenile()
	{
		vertexBuffer=Common.PosGenerator(Vertices);
		colorBuffer=Common.ColorGenerator(Vertices);
	}
	public void addVertex(Vertex v)
	{
		if(n<nvertices)
		{
			this.Vertices[n]=v;
			n++;
		}
		yenile();
	}
	public void ciz(GL10 gl) {	
		gl.glPushMatrix();
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, n);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_COLOR_ARRAY);	
		gl.glPopMatrix();
	}
}