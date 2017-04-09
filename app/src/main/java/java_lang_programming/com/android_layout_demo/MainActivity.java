package java_lang_programming.com.android_layout_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java_lang_programming.com.android_layout_demo.article81.BottomSheetBehaviorActivity;
import java_lang_programming.com.android_layout_demo.flexbox.FlexboxDemoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnFlexboxSample = (Button) findViewById(R.id.btn_flexbox_sample);
        btnFlexboxSample.setOnClickListener(v -> {
            moveFlexboxDemoActivity();
        });

        Button btnBottomSheetBehavior = (Button) findViewById(R.id.btn_bottom_sheet_behavior);
        btnBottomSheetBehavior.setOnClickListener(v -> {
            moveBottomSheetBehaviorActivity();
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void moveFlexboxDemoActivity() {
        Intent intent = new Intent(this, FlexboxDemoActivity.class);
        startActivity(intent);
    }

    private void moveBottomSheetBehaviorActivity() {
        Intent intent = new Intent(this, BottomSheetBehaviorActivity.class);
        startActivity(intent);
    }
}
