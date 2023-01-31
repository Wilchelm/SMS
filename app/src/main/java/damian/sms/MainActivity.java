package damian.sms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static MainActivity insance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String permission = Manifest.permission.RECEIVE_SMS;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        if (grant != PackageManager.PERMISSION_GRANTED) {
            String [] permision_list = new String[1];
            permision_list[0] = permission;
            ActivityCompat.requestPermissions(this, permision_list , 1);
        }
        insance = this;
    }
    public static MainActivity  getInstace(){
        return insance;
    }
    public void updateTextView(final String t) {
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(t);
            }
        });
    }
}
