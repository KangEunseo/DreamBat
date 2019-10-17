package kr.hs.emirim.dana.dreambat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MoreActivity extends AppCompatActivity {

    private ImageView heart;
    private ImageView message;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        heart = (ImageView)findViewById(R.id.heart);
        message = (ImageView)findViewById(R.id.message);

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MoreActivity.this, FriendsActivity.class);
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MoreActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
