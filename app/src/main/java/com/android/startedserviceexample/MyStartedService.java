package com.android.startedserviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.android.startedserviceexample.Utilities.LogType;

public class MyStartedService extends Service {

  public MyStartedService() {
  }

  @Override
  public void onCreate() {
    Utilities.log(LogType.i, "service onCreate.");
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Utilities.log(LogType.i, "Joe Seong-chan+20160570" +
        "\nid : " + startId);
//    Utilities.log(LogType.i, "id : " + startId);
    new Thread(() -> {
      int i = 0;
      while (i < 3) {
        try {
          i++;
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          Utilities.log(LogType.w, "thread sleep error. #" + i + ".");
        }
        Utilities.log(LogType.i, "service running. #" + i + ".");
      }
    }).start();
    return Service.START_STICKY;
  }

  @Override
  public IBinder onBind(Intent intent) {
    // TODO: Return the communication channel to the service.
    Utilities.log(LogType.i, "service onBind.");
    return null;
  }

  @Override
  public void onDestroy() {
    Utilities.log(LogType.i, "service onDestroy.");
  }
}