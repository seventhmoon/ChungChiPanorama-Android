package com.androidfung.cardboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ViewDataBinding binding =
//                DataBindingUtil.setContentView(this, R.layout.activity_main);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void onSampleButtonClick(View view) {
        // do something...
//        Log.d(TAG, "onSampleButtonClick");
        Intent intent = new Intent(view.getContext(), FullscreenPanoActivity.class);
        intent.putExtra(FullscreenPanoActivity.ARG_URI, Uri.parse(view.getTag().toString()));
        view.getContext().startActivity(intent);
    }
}
