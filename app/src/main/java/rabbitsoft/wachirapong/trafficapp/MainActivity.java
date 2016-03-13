package rabbitsoft.wachirapong.trafficapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        //Create ListView
        createListView();


    } //Main Method

    private void createListView() {

        final int[] intIcon = {R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03,
                R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06,
                R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09,
                R.drawable.traffic_10, R.drawable.traffic_11, R.drawable.traffic_12,
                R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15,
                R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18,
                R.drawable.traffic_19, R.drawable.traffic_20};


        final String[] titleStrings = new String[20];

        titleStrings[0]= "ห้ามเลี้ยวซ้าย";
        titleStrings[1]= "ห้ามเลี้ยวขวา";
        titleStrings[2]= "ตรงไป";
        titleStrings[3]= "บังคับเลี้ยวขวา";
        titleStrings[4]= "บังคับเลี้ยวซ้าย";
        titleStrings[5]= "ทางออก";
        titleStrings[6]= "ทางเข้า";
        titleStrings[7]= "ทางออก";
        titleStrings[8]= "หยุด";
        titleStrings[9]= "ความสูงไม่เกิน 2.50 เมตร";
        titleStrings[10]= "ทางแยก";
        titleStrings[11]= "ห้ามกลับรถ";
        titleStrings[12]= "ห้ามหยุดรถ";
        titleStrings[13]= "มีรถสวนทาง";
        titleStrings[14]= "ห้ามแซง";
        titleStrings[15]= "ทางเข้า";
        titleStrings[16]= "หยุดตรวจ";
        titleStrings[17]= "จำกัดความเร็ว";
        titleStrings[18]= "กำหนดความกว้าง";
        titleStrings[19]= "กำหนดความสูง";


        String[] detailStrings = getResources().getStringArray(R.array.detail_shot);

        My_Adapter my_adapter = new My_Adapter(MainActivity.this, intIcon, titleStrings
                , detailStrings);

        traffic_ListView.setAdapter(my_adapter);



        traffic_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("Title",titleStrings[i]);
                intent.putExtra("Image", intIcon[i]);
                intent.putExtra("Index",i);
                startActivity(intent);



            } // On ItemClick
        });


    }   //Create ListView


    private void buttonController() {

        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.attack);
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
