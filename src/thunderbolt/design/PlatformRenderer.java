package thunderbolt.design;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class PlatformRenderer implements Renderer {
	public int width,height;
	public float mX,mY;
	public Polygon c;
	public Rect r,r2;
	public Context context;
	public PlatformRenderer(Context context) {
		this.context=context;
		c=new Circle(new Position(200,200,100),new Color(1,0,0,1),100);
		r=new Rect(new Position(200,400,0),50,50);
		r2=new Rect(new Position(200,100,0),50,50);
		mX=0;
		mY=0;
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {	
		r.loadGLTexture(gl, this.context);
		r2.loadGLTexture(gl, this.context);
		gl.glEnable(GL10.GL_TEXTURE_2D);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f); 	
		gl.glClearDepthf(1.0f); 					
		gl.glEnable(GL10.GL_DEPTH_TEST); 			
		gl.glDepthFunc(GL10.GL_LEQUAL); 			
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST); 
	}
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		
		r.ciz(gl);
		r2.ciz(gl);
		c.ciz(gl);
	}
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		if(height == 0) { 				
			height = 1; 					
		}
		this.width=width;
		this.height=height;
		gl.glViewport(0, 0, width, height); 	
		gl.glMatrixMode(GL10.GL_PROJECTION); 	
		gl.glLoadIdentity(); 				
		GLU.gluOrtho2D(gl,0,width, height, 0);
		//GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);
		gl.glMatrixMode(GL10.GL_MODELVIEW); 
		gl.glLoadIdentity();
	}

}
