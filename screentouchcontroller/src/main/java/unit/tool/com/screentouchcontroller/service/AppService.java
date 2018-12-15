package unit.tool.com.screentouchcontroller.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

/**
 * 项目名称：ScreenTouchProject
 * 类描述：守护线程服务 5s拉取
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2018/12/14 16:34
 * 修改备注
 */
public class AppService extends Service implements Runnable {
    public static boolean isOnForeground = true;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(this).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void run() {
        while (true) {
            boolean isOnForegroundNew = isRunningOnForeground(this);

            if (isOnForegroundNew != isOnForeground) {
                toFront();
            }
            try {
                Thread.sleep(5000);
                Log.i("tag", "1");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static boolean isRunningOnForeground(Context context) {

        ActivityManager acm = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (acm != null) {
            List<ActivityManager.RunningAppProcessInfo> runApps = acm.getRunningAppProcesses();
            if (runApps != null && !runApps.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo app : runApps) {
                    if (app.processName.equals(context.getPackageName())) {
                        if (app.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                            return false;
                        }

                    }
                }
            }
        }
        return false;
    }

    private void toFront() {
        //获取ActivityManager
        ActivityManager mAm = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        //获得当前运行的task
        List<ActivityManager.RunningTaskInfo> taskList = mAm.getRunningTasks(100);
        for (ActivityManager.RunningTaskInfo rti : taskList) {
            //找到当前应用的task，并启动task的栈顶activity，达到程序切换到前台
            if (rti.topActivity.getPackageName().equals(getPackageName())) {
                mAm.moveTaskToFront(rti.id, 0);
                return;
            }
        }
        //若没有找到运行的task，用户结束了task或被系统释放，则重新启动mainactivity
        Intent resultIntent = new Intent();
        resultIntent.setClassName(this, "unit.tool.com.screentouchproject");
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(resultIntent);

    }
}
