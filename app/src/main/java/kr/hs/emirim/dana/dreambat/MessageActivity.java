package kr.hs.emirim.dana.dreambat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MessageActivity extends AppCompatActivity {

    private ImageView heart;
    private ImageView more;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

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
    }
}
