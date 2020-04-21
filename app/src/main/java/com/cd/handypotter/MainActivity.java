package com.cd.handypotter;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.cd.handypotter.utils.AudioWriterPCM;
import com.naver.speech.clientapi.SpeechRecognitionResult;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String CLIENT_ID = "84momc5apz";

    private RecognitionHandler handler;
    private NaverRecognizer naverRecognizer;
    private AudioWriterPCM writer;

    private TextView textView_01;
    private Button btnStart;
    private Button btnSubtitle;
    private String mResult;
    ArrayList<String> list_stt;
    ArrayList<String> outputSttList;

    private long startTime;

    // Handle speech recognition Messages.
    private void handleMessage(Message msg) {
        switch (msg.what) {
            case R.id.clientReady:
                // Now an user can speak.
                startTime = System.currentTimeMillis();
                String tv = "";
                if(list_stt.size() == 0){
                    tv ="";
                }else{
                    for(int i=0;i<list_stt.size();i++){
                        tv += list_stt.get(i)+"";
                    }
                }

                writer = new AudioWriterPCM(
                        Environment.getExternalStorageDirectory().getAbsolutePath() + "/NaverSpeechTest");
                writer.open("Test");
                btnStart.setText("stop");
                break;

            case R.id.audioRecording:
                writer.write((short[]) msg.obj);
                break;

            case R.id.partialResult:
                // Extract obj property typed with String.
                String tv2="";
                if(list_stt.size() ==0){
                    tv="";
                }else{
                    for(int i=0;i<list_stt.size();i++){
                        tv2 +=list_stt.get(i)+"\n";
                    }
                }

                mResult = (String) (msg.obj);
                textView_01.setText(mResult);
                break;

            case R.id.finalResult:
                // Extract obj property typed with String array.
                // The first element is recognition result for speech.
                SpeechRecognitionResult speechRecognitionResult = (SpeechRecognitionResult) msg.obj;
                List<String> results = speechRecognitionResult.getResults();
                String a = speechRecognitionResult.getResults().get(0);
                StringBuilder strBuf = new StringBuilder();
                for(String result : results) {
                    strBuf.append(result);
                    strBuf.append("\n");
                }
                String tv3 ="";
                mResult = a.toString();
                if(list_stt.size() ==0){
                    textView_01.setText(mResult);
                }else{
                    for(int i=0; i<list_stt.size();i++)
                        tv3 +=list_stt.get(i)+"";
                }
                list_stt.add(mResult);
                btnSubtitle.setVisibility(View.VISIBLE);
                //txtView.setText(mResult);
                break;

            case R.id.recognitionError:
                if (writer != null) {
                    writer.close();
                }

                mResult = "Error code : " + msg.obj.toString();
                textView_01.setText(mResult);
                btnStart.setText(R.string.str_start);
                btnStart.setEnabled(true);
                break;

            case R.id.clientInactive:
                if (writer != null) {
                    writer.close();
                }

                btnStart.setText("record");
                btnStart.setEnabled(true);
                break;
        }
    }

    public void setPermission(){
        final int PERMISSION =1;
        if ( Build.VERSION.SDK_INT >= 23 ){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET,
                    Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION);
        } /* ㄱ권권    한   설   정*/
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPermission();

        outputSttList = new ArrayList<String>();

        textView_01 = (TextView) findViewById(R.id.textView_01);
        btnStart = (Button) findViewById(R.id.btn_01);
        btnSubtitle = (Button)findViewById(R.id.btn_02);
        handler = new RecognitionHandler(this);
        naverRecognizer = new NaverRecognizer(this, handler, CLIENT_ID);
        list_stt = new ArrayList<String>();

        btnSubtitle.setVisibility(View.INVISIBLE);

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!naverRecognizer.getSpeechRecognizer().isRunning()) {
                    // Start button is pushed when SpeechRecognizer's state is inactive.
                    // Run SpeechRecongizer by calling recognize().
                    mResult = "";
                    textView_01.setText("Connecting...");
                    naverRecognizer.recognize();

                } else {
                    Log.d(TAG, "stop and wait Final Result");

                    btnStart.setEnabled(false);
                    naverRecognizer.getSpeechRecognizer().stop();
                    btnSubtitle.setVisibility(View.VISIBLE);

                }
            }
        });


        btnSubtitle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, subtitleActivity.class);
                    intent.putExtra("mResult",mResult);
                    startActivity(intent);
                    finish();

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        // NOTE : initialize() must be called on start time.
        naverRecognizer.getSpeechRecognizer().initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mResult = "";
        textView_01.setText("");
        btnStart.setText("record");
        btnStart.setEnabled(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // NOTE : release() must be called on stop time.
        naverRecognizer.getSpeechRecognizer().release();
    }

    // Declare handler for handling SpeechRecognizer thread's Messages.
    static class RecognitionHandler extends Handler {
        private final WeakReference<MainActivity> mActivity;

        RecognitionHandler(MainActivity activity) {
            mActivity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mActivity.get();
            if (activity != null) {
                activity.handleMessage(msg);
            }
        }
    }
}
