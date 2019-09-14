package kr.hs.emirim.dana.dreambat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDoteLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mSkipBtn;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        mSlideViewPager = (ViewPager)findViewById(R.id.slideViewPager);
        mDoteLayout = (LinearLayout)findViewById(R.id.dotsLayout);

        mSkipBtn = (Button)findViewById(R.id.skipBtn);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

/*      mSkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(2);
            }
        }); */
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        mDoteLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            mDoteLayout.addView(mDots[i]);
        }

        if(mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            mCurrentPage = i;

            if(i == 2) {
                mSkipBtn.setEnabled(false);
                mSkipBtn.setVisibility(View.INVISIBLE);

                mSkipBtn.setText("");
            } else {
                mSkipBtn.setEnabled(true);
                mSkipBtn.setVisibility(View.VISIBLE);

                mSkipBtn.setText("SKIP");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    };
}
