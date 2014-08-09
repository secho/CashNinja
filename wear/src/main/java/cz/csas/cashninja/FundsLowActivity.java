package cz.csas.cashninja;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WatchViewStub;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import cz.csas.cashninja.R;

public class FundsLowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insufficient_funds);


        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {


                CircledImageView mCircledImageView = (CircledImageView) stub.findViewById(R.id.insf_circle);

                //Listener to send the message (it is just an example)
                mCircledImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(FundsLowActivity.this, AccountTypeActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });
    }



}
