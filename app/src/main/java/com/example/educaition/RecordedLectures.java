package com.example.educaition;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
public class RecordedLectures extends AppCompatActivity {
    VideoView simpleVideoView;
    MediaController mediaControls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recorded_lectures);
        simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);
        if (mediaControls == null) {
            mediaControls = new MediaController(RecordedLectures.this);
            mediaControls.setAnchorView(simpleVideoView);
        }
        simpleVideoView.setMediaController(mediaControls);
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.class_video));
        simpleVideoView.start();

        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
            }
        });
        simpleVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });
    }

}
