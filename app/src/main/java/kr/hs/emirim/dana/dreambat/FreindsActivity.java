package kr.hs.emirim.dana.dreambat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import kr.hs.emirim.dana.dreambat.Adapter.ListViewAdapter;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;

public class FreindsActivity extends FragmentActivity {

    private ListView listView;
    private ListViewAdapter adapter;

    private int[] img = {R.drawable.profile,R.drawable.profile,R.drawable.profile};
    private String[] name = {"뽀글깨비","뾰족깨비","쭉쭉깨비"};
    private String[] id = {"응원챗봇","미션챗봇","음악챗봇"};
    private String[] content = {"너의 꿈을 응원해~", "꿈을 이루기 위한 미션과 테스트를 수행해봐!", "꿈에 대한 음악을 들려줄게♪"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freinds);

        listView = (ListView)findViewById(R.id.listView);

        adapter = new ListViewAdapter();    //변수 초기화
        listView.setAdapter(adapter);   //어댑터 할당

        //adapter를 통한 값 전달
        for(int i=0; i<img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this,img[i]),name[i], id[i], content[i]);
        }
        adapter.notifyDataSetChanged();
    }
}