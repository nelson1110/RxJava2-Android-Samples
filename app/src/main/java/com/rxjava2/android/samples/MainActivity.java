package com.rxjava2.android.samples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rxjava2.android.samples.operators.AsyncSubjectExampleActivity;
import com.rxjava2.android.samples.operators.BehaviorSubjectExampleActivity;
import com.rxjava2.android.samples.operators.BufferExampleActivity;
import com.rxjava2.android.samples.operators.CompletableObserverExampleActivity;
import com.rxjava2.android.samples.operators.ConcatExampleActivity;
import com.rxjava2.android.samples.operators.DebounceExampleActivity;
import com.rxjava2.android.samples.operators.DeferExampleActivity;
import com.rxjava2.android.samples.operators.DisposableExampleActivity;
import com.rxjava2.android.samples.operators.DistinctExampleActivity;
import com.rxjava2.android.samples.operators.FilterExampleActivity;
import com.rxjava2.android.samples.operators.FlowableExampleActivity;
import com.rxjava2.android.samples.operators.IntervalExampleActivity;
import com.rxjava2.android.samples.operators.LastOperatorExampleActivity;
import com.rxjava2.android.samples.operators.MapExampleActivity;
import com.rxjava2.android.samples.operators.MergeExampleActivity;
import com.rxjava2.android.samples.operators.PublishSubjectExampleActivity;
import com.rxjava2.android.samples.operators.ReduceExampleActivity;
import com.rxjava2.android.samples.operators.ReplayExampleActivity;
import com.rxjava2.android.samples.operators.ReplaySubjectExampleActivity;
import com.rxjava2.android.samples.operators.ScanExampleActivity;
import com.rxjava2.android.samples.operators.SimpleExampleActivity;
import com.rxjava2.android.samples.operators.SingleObserverExampleActivity;
import com.rxjava2.android.samples.operators.SkipExampleActivity;
import com.rxjava2.android.samples.operators.TakeExampleActivity;
import com.rxjava2.android.samples.operators.ThrottleFirstExampleActivity;
import com.rxjava2.android.samples.operators.ThrottleLastExampleActivity;
import com.rxjava2.android.samples.operators.TimerExampleActivity;
import com.rxjava2.android.samples.operators.WindowExampleActivity;
import com.rxjava2.android.samples.operators.ZipExampleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSimpleActivity(View view) {
        startActivity(new Intent(MainActivity.this, SimpleExampleActivity.class));
    }

    public void startMapActivity(View view) {
        startActivity(new Intent(MainActivity.this, MapExampleActivity.class));
    }

    public void startZipActivity(View view) {
        startActivity(new Intent(MainActivity.this, ZipExampleActivity.class));
    }

    public void startDisposableActivity(View view) {
        startActivity(new Intent(MainActivity.this, DisposableExampleActivity.class));
    }

    public void startTakeActivity(View view) {
        startActivity(new Intent(MainActivity.this, TakeExampleActivity.class));
    }

    public void startTimerActivity(View view) {
        startActivity(new Intent(MainActivity.this, TimerExampleActivity.class));
    }

    public void startIntervalActivity(View view) {
        startActivity(new Intent(MainActivity.this, IntervalExampleActivity.class));
    }

    public void startSingleObserverActivity(View view) {
        startActivity(new Intent(MainActivity.this, SingleObserverExampleActivity.class));
    }

    public void startCompletableObserverActivity(View view) {
        startActivity(new Intent(MainActivity.this, CompletableObserverExampleActivity.class));
    }

    public void startFlowableActivity(View view) {
        startActivity(new Intent(MainActivity.this, FlowableExampleActivity.class));
    }

    public void startReduceActivity(View view) {
        startActivity(new Intent(MainActivity.this, ReduceExampleActivity.class));
    }

    public void startBufferActivity(View view) {
        startActivity(new Intent(MainActivity.this, BufferExampleActivity.class));
    }

    public void startFilterActivity(View view) {
        startActivity(new Intent(MainActivity.this, FilterExampleActivity.class));
    }

    public void startSkipActivity(View view) {
        startActivity(new Intent(MainActivity.this, SkipExampleActivity.class));
    }

    public void startScanActivity(View view) {
        startActivity(new Intent(MainActivity.this, ScanExampleActivity.class));
    }

    public void startReplayActivity(View view) {
        startActivity(new Intent(MainActivity.this, ReplayExampleActivity.class));
    }

    public void startConcatActivity(View view) {
        startActivity(new Intent(MainActivity.this, ConcatExampleActivity.class));
    }

    public void startMergeActivity(View view) {
        startActivity(new Intent(MainActivity.this, MergeExampleActivity.class));
    }

    public void startDeferActivity(View view) {
        startActivity(new Intent(MainActivity.this, DeferExampleActivity.class));
    }

    public void startDistinctActivity(View view) {
        startActivity(new Intent(MainActivity.this, DistinctExampleActivity.class));
    }

    public void startLastOperatorActivity(View view) {
        startActivity(new Intent(MainActivity.this, LastOperatorExampleActivity.class));
    }

    public void startReplaySubjectActivity(View view) {
        startActivity(new Intent(MainActivity.this, ReplaySubjectExampleActivity.class));
    }

    public void startPublishSubjectActivity(View view) {
        startActivity(new Intent(MainActivity.this, PublishSubjectExampleActivity.class));
    }

    public void startBehaviorSubjectActivity(View view) {
        startActivity(new Intent(MainActivity.this, BehaviorSubjectExampleActivity.class));
    }

    public void startAsyncSubjectActivity(View view) {
        startActivity(new Intent(MainActivity.this, AsyncSubjectExampleActivity.class));
    }

    public void startThrottleFirstActivity(View view) {
        startActivity(new Intent(MainActivity.this,ThrottleFirstExampleActivity.class));
    }

    public void startThrottleLastActivity(View view) {
        startActivity(new Intent(MainActivity.this, ThrottleLastExampleActivity.class));
    }

    public void startDebounceActivity(View view) {
        startActivity(new Intent(MainActivity.this, DebounceExampleActivity.class));
    }

    public void startWindowActivity(View view) {
        startActivity(new Intent(MainActivity.this,WindowExampleActivity.class));
    }


}
