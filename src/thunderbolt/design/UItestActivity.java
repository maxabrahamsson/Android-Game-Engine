package thunderbolt.design;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class OyunBaslat implements OnClickListener {
    private Context c1;
    public OyunBaslat(Context  c1) {

       this.c1=c1;
    }
  
    public void onClick(View v) {
        Intent i = new Intent(c1,PlatformActivity.class);
        c1.startActivity(i);
    }
 }

public class UItestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn1 = (Button) findViewById(R.id.button1);
        OyunBaslat temp=new OyunBaslat(this);
		btn1.setOnClickListener(temp);
    }
}