package com.hipradeep.learnandroid.asynctaskexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hipradeep.learnandroid.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TypeAsyncTaskActivity extends AppCompatActivity {

    ProgressBar progressBarInd;
    ImageView iv_set_img;
    SwitchCompat sc_change_img;
    TextView tv_task;
    Button btn_run_on_main_thread, btn_run_task_old, btn_run_task_new;
    private String TAG = "Pradeep";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_async_task);
        progressBarInd = findViewById(R.id.progressBarInd);
        iv_set_img = findViewById(R.id.iv_set_img);
        sc_change_img = findViewById(R.id.switch_change_img);
        progressBarInd = findViewById(R.id.progressBarInd);
        tv_task = findViewById(R.id.tv_task);
        btn_run_on_main_thread = findViewById(R.id.btn_run_on_main_thread);
        btn_run_task_old = findViewById(R.id.btn_run_task_old);
        btn_run_task_new = findViewById(R.id.btn_run_task_new);

        // make initial progress bar invisible
        progressBarInd.setVisibility(View.INVISIBLE);

        iv_set_img.setBackgroundResource(R.drawable.undraw_1);

        sc_change_img.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (sc_change_img.isChecked()) {
                    iv_set_img.setBackgroundResource(R.drawable.undraw_2);
                } else {
                    iv_set_img.setBackgroundResource(R.drawable.undraw_1);
                }
            }
        });


        btn_run_on_main_thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_task.setText("task executing...");
                disableAllButton();

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                enableAllButton();
                tv_task.setText("task completed");
            }
        });


        btn_run_task_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        btn_run_task_old.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //UploadTask uploadTask = new UploadTask();
        //uploadTask.execute();
        new UploadTask().execute("This is the string passaed.");
            }
        });


    }

     void disableAllButton() {
         btn_run_on_main_thread.setEnabled(false);
         btn_run_task_new.setEnabled(false);
         btn_run_task_old.setEnabled(false);

    }

    void enableAllButton() {
         btn_run_on_main_thread.setEnabled(true);
         btn_run_task_new.setEnabled(true);
         btn_run_task_old.setEnabled(true);

    }


    //Default constructor in android.os.AsyncTask is deprecated
    class UploadTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute: " + Thread.currentThread().getName());

            tv_task.setText("task executing...");
            progressBarInd.setVisibility(View.VISIBLE);
            disableAllButton();
        }

        @Override
        protected String doInBackground(String... strings) {

            Log.i(TAG, "doInBackground: string passed:" + strings[0]);
            Log.i(TAG, "doInBackground: Thread: " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }

            return "finally the task is complete";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBarInd.setProgress(values[0] + 1);
            Log.i(TAG, "onProgressUpdate: " + Thread.currentThread().getName());
        }

        @Override
        protected void onPostExecute(String string) {
            Log.i(TAG, "onPostExecute: " + Thread.currentThread().getName());

            tv_task.setText(string);
            progressBarInd.setVisibility(View.INVISIBLE);
           enableAllButton();
        }
    }


    //--------------------------------------------------------
    //--------------------java.util.concurrent----------------
    //--------------------------------------------------------

    // Create some member variables for the ExecutorService
    // and for the Handler that will update the UI from the main thread
    ExecutorService mExecutor = Executors.newSingleThreadExecutor();
    Handler mHandler = new Handler(Looper.getMainLooper());

    // Create an interface to respond with the result after processing
    public interface OnProcessedListener {
        public void onProcessed(int result);
    }

    private void processInBg(final String url, final boolean finished){

        final OnProcessedListener listener = new OnProcessedListener(){

            @Override
            public void onProcessed(int result){
                // Use the handler so we're not trying to update the UI from the bg thread
                mHandler.post(new Runnable(){
                    @Override
                    public void run(){
                        // Update the UI here
                       // updateUi(result);

                        // ...

                        // If we're done with the ExecutorService, shut it down.
                        // (If you want to re-use the ExecutorService,
                        // make sure to shut it down whenever everything's completed
                        // and you don't need it any more.)
                        if(finished){
                            mExecutor.shutdown();
                        }
                    }
                });
            }
        };

      //  runOnUiThread();
        Runnable backgroundRunnable = new Runnable(){
            @Override
            public void run(){
                // Perform your background operation(s) and set the result(s)
               // Event result = Utils.fetchEarthquakeData(url);

                // ...

                // Use the interface to pass along the result
               //listener.onProcessed(result);
            }
        };

        mExecutor.execute(backgroundRunnable);
    }



}











//https://developer.android.com/reference/android/os/AsyncTask