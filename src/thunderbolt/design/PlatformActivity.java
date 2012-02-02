package thunderbolt.design;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class PlatformActivity  extends Activity implements OnClickListener {
	public GLSurfaceView sv;
	public PlatformRenderer renderer=new PlatformRenderer(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        sv=new GLSurfaceView(this);
        sv.setRenderer(renderer);
        setContentView(sv);
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Remember to resume the glSurface
	 */
	@Override
	protected void onResume() {
		super.onResume();
		sv.onResume();
	}

	/**
	 * Also pause the glSurface
	 */
	@Override
	protected void onPause() {
		super.onPause();
		sv.onPause();
	}
}
