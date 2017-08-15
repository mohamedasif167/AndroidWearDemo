package asif167.wordpress.com.androidweardemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView mTextView;
    Button btnSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub)
                findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new
                                                 WatchViewStub.OnLayoutInflatedListener() {

                                                     @Override
                                                     public void onLayoutInflated(WatchViewStub stub) {
                                                         mTextView = (TextView) stub.findViewById(R.id.text);
                                                         btnSpeak = (Button) stub.findViewById(R.id.btnSpeak);

                                                         btnSpeak.setOnClickListener(new View.OnClickListener() {
                                                             @Override
                                                             public void onClick(View v) {
                                                                 Intent intent = new Intent
                                                                         (RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                                                                 intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                                                         RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                                                                 startActivityForResult(intent, 1);
                                                             }
                                                         });
                                                     }
                                                 });
    }}
