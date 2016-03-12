package rabbitsoft.wachirapong.trafficapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    //Explicit
    private ListView traffic_ListView;
    private Button aboutMeButton;
    
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //BindWidget
        bindWidget();

        //Button Controller
        buttonController();

    } //Main Method


    private void buttonController() {

        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.bird_maxican);
                mediaPlayer.start();


                //WebView
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/oC5d3Eo0TL8"));
                startActivity(intent);

            }   //OnClck
        });

    }   //Button Controller Method


    private void bindWidget() {
        traffic_ListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);
    }   // Bind Widget Method


} //Main Class
