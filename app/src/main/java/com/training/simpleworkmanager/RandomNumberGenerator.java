package com.training.simpleworkmanager;

import android.util.Log;

import java.util.Random;

public class RandomNumberGenerator {

    private static final String TAG = "Yoke.MyRandomNumberGeneratorWorker";

    private int randomNumber;
    private boolean isRandomGeneratorOn;

    private final int MIN = 0;
    private final int MAX = 100;

    public void startRandomNumberGenerator() {
        Log.e(TAG, "Thread id: " + Thread.currentThread().getName() + ", Start Random Number Generator");
        int i = 0;
        isRandomGeneratorOn = true;
        while (i < 5) {
            try {
                if (!isRandomGeneratorOn) {
                    break;
                }
                Thread.sleep(1000);
                randomNumber = new Random().nextInt(MAX) + MIN;
                Log.e(TAG, "Thread id: " + Thread.currentThread().getName() + ", Random Number: " + randomNumber);
                i++;
            } catch (Exception e) {
                Log.e(TAG, "Thread Interrupted");
            }
        }
    }

    public void stopRandomNumberGenerator() {
        Log.e(TAG, "Thread id: " + Thread.currentThread().getName() + ", Stopped Random Number");
        isRandomGeneratorOn = false;
    }
}