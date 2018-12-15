package unit.tool.com.screentouchcontroller.utils;

import android.app.Application;
import android.content.Intent;
import android.os.Process;

/**
 * 项目名称：ScreenTouchProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2018/12/15 15:25
 * 修改备注
 */
public class CrashHelpUtils {

    private static CrashHelpUtils instance;


    //提供crashApp拉取服务
    public void RegisterApp(final Application app, final String mclassName){
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //通过java反射实现启动
                //无限重启
                Intent intent =new Intent();
                intent.setClassName(app,mclassName);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                app.startActivity(intent);
                android.os.Process.killProcess(Process.myPid());
            }
        });
    }

    /**
     * 异常捕获
     * 该异常是非捕获异常，需要check
     *
     */


    //提供全局单例
    public static CrashHelpUtils getInstance() {
        if(instance==null){
            instance=new CrashHelpUtils();
        }
        return instance;
    }
}
