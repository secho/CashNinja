package cz.csas.cashninja;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;

public class TransferActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub_transfer);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);

                final DelayedConfirmationView dcv = (DelayedConfirmationView) stub.findViewById(R.id.delayed_confirmation_transfer);
                dcv.setTotalTimeMs(3000);
                dcv.setListener(new DelayedConfirmationView.DelayedConfirmationListener() {
                    @Override
                    public void onTimerFinished(View view) {
                        Intent intent = new Intent(TransferActivity.this, ConfirmActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onTimerSelected(View view) {
                        Intent intent = new Intent(TransferActivity.this, ConfirmActivity.class);
                        startActivity(intent);
                    }
                });
                dcv.start();
            }
        });




    }


}
