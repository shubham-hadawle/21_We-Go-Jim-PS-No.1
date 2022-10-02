package com.example.educaition;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;

public class VirtualAi extends AppCompatActivity {
    private SpeechRecognizer recognizer = SpeechRecognizer.createSpeechRecognizer(this);
    private TextToSpeech tts;
    String textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.virtual_ai);
        initializeResults();
        initializeTextToSpeech();

        Dexter.withContext(this)
                .withPermission(Manifest.permission.RECORD_AUDIO)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {/* ... */}

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        System.exit(0);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();

    }

    private void initializeTextToSpeech() {
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onInit(int i) {
                if (tts.getEngines().size()==0)
                {
                    Toast.makeText(VirtualAi.this, "Engine is not available", Toast.LENGTH_SHORT).show();
                }
                else speak("Hi I am Donna...Your personal A I assistant.");
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speak(String message)
    {

        tts.speak(message,TextToSpeech.QUEUE_FLUSH,null, null);

    }
    private void initializeResults() {
        if(SpeechRecognizer.isRecognitionAvailable(this))
        {

            recognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle bundle) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float v) {

                }

                @Override
                public void onBufferReceived(byte[] bytes) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int i) {

                }

                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onResults(Bundle bundle) {
                    ArrayList<String> result = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    Toast.makeText(VirtualAi.this, "" + result.get(0),Toast.LENGTH_SHORT).show();
                    textResult = result.get(0);
                    TextView textView = findViewById(R.id.textResult);
                    textView.setText(textResult);
                    response(textResult);
                }

                @Override
                public void onPartialResults(Bundle bundle) {

                }

                @Override
                public void onEvent(int i, Bundle bundle) {

                }
            });
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void response(String message) {
        String messages = message.toLowerCase();
        if(messages.contains("hi") || messages.contains("hello"))
        {
            speak("Hi, what can i do for you");
        }
        else if(messages.contains("name") && message.contains("your"))
        {
            speak("My name is Donna");
        }
        else if(messages.contains("launch main activity"))
        {
            speak("Launching Main Activity");
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if(messages.contains("launch prediction") )
        {
            speak("Launching Prediction Activity");
            Intent i = new Intent(this, PredictionModel.class);
            startActivity(i);
        }
        else if(messages.contains("launch recorded") )
        {
            speak("Launching Recorded Video Section");
            Intent i = new Intent(this, RecordedLectures.class);
            startActivity(i);
        }
        else if(messages.contains("help") || message.contains("Scholarship"))
        {
            speak("You can go to prediction section of the app fill details and click prediction button to know about your scholorship chances");
        }
        else if(messages.contains("Who made you"))
        {
            speak("No one");
        }
        else{
            speak("Sorry I don't know that one");
        }

    }

    public void startRecording(View view)
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
        recognizer.startListening(intent);
    }
}
