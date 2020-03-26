package jetpack.zmkj.com.jetpack;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWork extends Worker {
    public MyWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Data data = getInputData();
        final String value = data.getString("key");
        Log.e("MyWork", value);


        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
            }
        });

        return Result.success();
    }

    @Override
    public void onStopped() {
        super.onStopped();
        Log.e("MyWork", "onStopped");
    }
}
