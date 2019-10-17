package kr.hs.emirim.dana.dreambat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MoreActivity extends AppCompatActivity {

    private ImageView heart;
    private ImageView message;
    private ImageView settings;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        heart = (ImageView)findViewById(R.id.heart);
        message = (ImageView)findViewById(R.id.message);
        settings = (ImageView)findViewById(R.id.settings);

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

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MoreActivity.this, MyActivity.class);
                startActivity(intent);
            }
        });
    }
}
