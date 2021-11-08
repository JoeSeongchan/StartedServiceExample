package com.android.startedserviceexample;

import android.util.Log;

public class Utilities {

  public static String makeFuncTag() {
    String curFuncName = Thread.currentThread().getStackTrace()[3].getMethodName();
    return " - " + curFuncName + "\n";
  }


  public static void log(LogType type, String msg) {
    String callerClassName = Thread.currentThread().getStackTrace()[3].getClassName();
    int lastIndexOfDot = callerClassName.lastIndexOf(".");
    int endIdx = callerClassName.length();
    final String TAG = callerClassName.substring(lastIndexOfDot, endIdx) + "_R";
    String callerFuncName = Thread.currentThread().getStackTrace()[3].getMethodName();
    final String FUNC_TAG = "FN : " + callerFuncName + "\n";
    final String MSG = "MSG : " + msg;
    switch (type) {
      case d:
      default:
        Log.d(TAG, FUNC_TAG + MSG);
        break;
      case i:
        Log.i(TAG, FUNC_TAG + MSG);
        break;
      case w:
        Log.w(TAG, FUNC_TAG + MSG);
        break;
    }
  }

  public enum LogType {i, d, w}
}
