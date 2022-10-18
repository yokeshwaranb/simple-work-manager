package com.training.simpleworkmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker{

    private static final String TAG = "Yoke.MyWorker";

    private Context context;
    private WorkerParameters workerParameters;

    private RandomNumberGenerator randomNumberGenerator;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        Log.e(TAG, "Thread id: " + Thread.currentThread().getName() + " Created MyWorker");
        this.context = context;
        this.workerParameters = workerParams;
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.e(TAG, "Thread id: " + Thread.currentThread().getName() + " Started Worker");
        randomNumberGenerator.startRandomNumberGenerator();
        return Result.success();
    }

    @Override
    public void onStopped() {
        randomNumberGenerator.stopRandomNumberGenerator();
        Log.e(TAG, "Thread id: " + Thread.currentThread().getName() + " Worker has been stopped ");
        super.onStopped();
    }
}
