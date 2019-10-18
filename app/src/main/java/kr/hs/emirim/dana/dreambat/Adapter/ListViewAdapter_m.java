package kr.hs.emirim.dana.dreambat.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.hs.emirim.dana.dreambat.ListVO.ListVO_m;
import kr.hs.emirim.dana.dreambat.R;

public class ListViewAdapter_m extends BaseAdapter {

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListVO_m> listVO_m = new ArrayList<ListVO_m>() ;
    // ListViewAdapter의 생성자
    public ListViewAdapter_m() { }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listVO_m.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //position = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();

        // "custom_listview" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_listview_m, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView image = (ImageView) convertView.findViewById(R.id.img) ;
        TextView name = (TextView) convertView.findViewById(R.id.name) ;
        TextView time = (TextView) convertView.findViewById(R.id.time) ;
        TextView content = (TextView) convertView.findViewById(R.id.content) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListVO_m listViewItem = listVO_m.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        image.setImageDrawable(listViewItem.getImg());
        name.setText(listViewItem.getName());
        time.setText(listViewItem.getTime());
        content.setText(listViewItem.getContent());

        //리스트뷰 클릭 이벤트
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, (pos+1)+"번째 리스트가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        // 프로필 원형으로 만들기
        image.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21) {
            image.setClipToOutline(true);
        }

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listVO_m.get(position);
    }

    // 데이터값 넣어줌
    public void addVO_m(Drawable img, String name, String time, String content) {
        ListVO_m item = new ListVO_m();

        item.setImg(img);
        item.setName(name);
        item.setTime(time);
        item.setContent(content);

        listVO_m.add(item);
    }
}
