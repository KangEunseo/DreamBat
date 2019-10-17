package kr.hs.emirim.dana.dreambat;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import kr.hs.emirim.dana.dreambat.Adapter.ListViewAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class FriendsActivity extends FragmentActivity {

    private ListView listView;
    private ListViewAdapter adapter;
    private ImageView message;
    private ImageView more;
    private Intent intent;

    private int[] img = {R.drawable.p1, R.drawable.p2, R.drawable.p3};
    private String[] name = {"뽀글깨비","뾰족깨비","쭉쭉깨비"};
    private String[] id = {"응원챗봇","미션챗봇","음악챗봇"};
    private String[] content = {"너의 꿈을 응원해~", "꿈을 이루기 위한 미션과 테스트를 수행해봐!", "꿈에 대한 음악을 들려줄게♪"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        listView = (ListView)findViewById(R.id.listView);
        message = (ImageView)findViewById(R.id.message);
        more = (ImageView)findViewById(R.id.more);

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(FriendsActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(FriendsActivity.this, MoreActivity.class);
                startActivity(intent);
            }
        });

        adapter = new ListViewAdapter();    //변수 초기화
        listView.setAdapter(adapter);   //어댑터 할당

        //adapter를 통한 값 전달
        for(int i=0; i<img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this, img[i]), name[i], id[i], content[i]);
        }
        adapter.notifyDataSetChanged();
    }
}