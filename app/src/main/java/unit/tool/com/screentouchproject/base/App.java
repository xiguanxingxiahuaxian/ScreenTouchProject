package unit.tool.com.screentouchproject.base;

import android.app.Application;

import unit.tool.com.screentouchcontroller.utils.CrashHelpUtils;

/**
 * 项目名称：ScreenTouchProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2018/12/14 16:54
 * 修改备注
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //demo 测试方案  线程设置监控
        CrashHelpUtils.getInstance().RegisterApp(this, "unit.tool.com.screentouchproject.MainActivity");
    }

}
