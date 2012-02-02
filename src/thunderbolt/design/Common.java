package thunderbolt.design;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import android.util.Log;

public class Common {
	static FloatBuffer PosGenerator(Vertex[] Vertices)
	{
		FloatBuffer vertexBuffer;
		float[] array=new float[Vertices.length*3];
		for(int i=0; i<Vertices.length; i++)
		{
			if(Vertices[i]!=null)
			{
				array[i*3]=Vertices[i].getPosition().getX();
				array[i*3+1]=Vertices[i].getPosition().getY();			
				array[i*3+2]=Vertices[i].getPosition().getZ();
			}
		}
		ByteBuffer byteBuf = ByteBuffer.allocateDirect(array.length * 4);
		byteBuf.order(ByteOrder.nativeOrder());
		vertexBuffer = byteBuf.asFloatBuffer();
		vertexBuffer.put(array);
		vertexBuffer.position(0);
		return vertexBuffer;
	}
	static FloatBuffer ColorGenerator(Vertex[] Vertices)
	{
		FloatBuffer vertexBuffer;
		float[] array=new float[Vertices.length*4];
		for(int i=0; i<Vertices.length; i++)
		{
			if(Vertices[i]!=null)
			{
				array[i*4]=Vertices[i].getColor().getR();
				array[i*4+1]=Vertices[i].getColor().getG();			
				array[i*4+2]=Vertices[i].getColor().getB();
				array[i*4+3]=Vertices[i].getColor().getA();
			}
		}
		ByteBuffer byteBuf = ByteBuffer.allocateDirect(array.length * 4);
		byteBuf.order(ByteOrder.nativeOrder());
		vertexBuffer = byteBuf.asFloatBuffer();
		vertexBuffer.put(array);
		vertexBuffer.position(0);
		return vertexBuffer;
	}
}
