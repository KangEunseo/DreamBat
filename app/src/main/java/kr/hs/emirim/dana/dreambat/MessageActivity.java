package kr.hs.emirim.dana.dreambat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import kr.hs.emirim.dana.dreambat.Adapter.ListViewAdapter_m;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class MessageActivity extends AppCompatActivity {
    private ListView listView_m;
    private ListViewAdapter_m adapter_m;
    private ImageView heart;
    private ImageView more;
    private Intent intent;

    private int[] img = {R.drawable.p1, R.drawable.p2, R.drawable.p3};
    private String[] name = {"뽀글깨비","뾰족깨비","쭉쭉깨비"};
    private String[] time = {"11:00", "12:00", "13:00"}; //마지막 대화 시간
    private String[] content = {"11:00", "12:00", "13:00"}; //마지막 대화 내용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        listView_m = (ListView)findViewById(R.id.listView);
        heart = (ImageView)findViewById(R.id.heart);
        more = (ImageView)findViewById(R.id.more);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MessageActivity.this, FriendsActivity.class);
                startActivity(intent);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MessageActivity.this, MoreActivity.class);
                startActivity(intent);
            }
        });

        adapter_m = new ListViewAdapter_m();    //변수 초기화
        listView_m.setAdapter(adapter_m);   //어댑터 할당

        //adapter를 통한 값 전달
        for(int i=0; i<img.length;i++){
            adapter_m.addVO_m(ContextCompat.getDrawable(this, img[i]), name[i], time[i], content[i]);
        }
        adapter_m.notifyDataSetChanged();
    }
}
