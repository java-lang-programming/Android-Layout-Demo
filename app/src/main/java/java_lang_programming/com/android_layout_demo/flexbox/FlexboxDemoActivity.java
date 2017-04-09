package java_lang_programming.com.android_layout_demo.flexbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.google.android.flexbox.FlexboxLayout;

import java_lang_programming.com.android_layout_demo.R;

public class FlexboxDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexbox_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
    }

    private void init() {
        FlexboxLayout flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
        flexboxLayout.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW);

        FlexboxLayout flexboxLayout2 = (FlexboxLayout) findViewById(R.id.flexbox_layout2);
        flexboxLayout2.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_ROW);

        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sample_20161204_180343));
//            FlexboxLayout.LayoutParams params = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT);
//            params.setMargins(10, 10, 0, 0);  // left, top, right, bottom
            //Toolbar.LayoutParams params1 = (LayoutParams)imageView.getLayoutParams();
            //ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams)imageView.getLayoutParams();
            //lp.leftMargin = 8;
            //lp.bottomMargin = 8;
            //imageView.setLayoutParams(params);
            flexboxLayout.addView(imageView);
        }

        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sample_20161204_180343));
            FlexboxLayout.LayoutParams params = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 10, 0, 0);  // left, top, right, bottom
            //Toolbar.LayoutParams params1 = (LayoutParams)imageView.getLayoutParams();
            //ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams)imageView.getLayoutParams();
            //lp.leftMargin = 8;
            //lp.bottomMargin = 8;
            imageView.setLayoutParams(params);
            flexboxLayout2.addView(imageView);
        }

        //flexboxLayout.addView();
    }

}
