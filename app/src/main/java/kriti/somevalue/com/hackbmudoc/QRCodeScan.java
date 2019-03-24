package kriti.somevalue.com.hackbmudoc;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRCodeScan extends AppCompatActivity {

    Button btnScanQr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scan);

        btnScanQr=(Button) findViewById(R.id.btnScanQR);

        ActionBar actionBar=getSupportActionBar();
        LinearLayout ll=new LinearLayout(this);
        TextView textView=new TextView(this);
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(R.drawable.logo);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setGravity(Gravity.CENTER_HORIZONTAL);
        ll.addView(textView);
        ll.addView(imageView);
        textView.setText("Welcome!");
        actionBar.setCustomView(textView);


        btnScanQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator=new IntentIntegrator(QRCodeScan.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                integrator.setPrompt("Scanning...");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.setCaptureActivity(MyCaptureActivity.class);
                integrator.setOrientationLocked(true);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        //Toast.makeText(this, result.getContents().toString(), Toast.LENGTH_SHORT).show();
        Intent intentToHistory=new Intent(QRCodeScan.this,History.class);
        intentToHistory.putExtra("HASHCODE",result.getContents());
        startActivity(intentToHistory);

    }
}
