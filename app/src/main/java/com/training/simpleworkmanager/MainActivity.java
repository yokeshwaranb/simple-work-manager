package com.training.simpleworkmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Yoke.MainActivity";

    private Button btnStartWorker;
    private Button btnStopWorker;

    private WorkManager workManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartWorker = findViewById(R.id.btnStartWork);
        btnStopWorker = findViewById(R.id.btnStopWork);

        workManager = WorkManager.getInstance(this);

        btnStartWorker.setOnClickListener(v -> startWorker());
        btnStopWorker.setOnClickListener(v -> stopWorker());
    }

    private void startWorker() {
        Log.e(TAG, "@startWorker()");
        WorkRequest workRequest = new PeriodicWorkRequest.Builder(MyWorker.class, 10, TimeUnit.SECONDS).build();
        workManager.enqueue(workRequest);
    }

    private void stopWorker() {
        Log.e(TAG, "@stopWorker()");
        workManager.cancelAllWork();
    }
}