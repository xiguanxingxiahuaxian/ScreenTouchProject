package unit.tool.com.screentouchcontroller.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import unit.tool.com.screentouchcontroller.R;

/**
 * 项目名称：ScreenTouchProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2018/12/13 16:38
 * 修改备注
 */
public class ScreenUtils {

    private Context context;
    private static ScreenUtils screenUtils;
    private WindowManager window;
    private View view;

    public ScreenUtils(Context context) {
        this.context = context;
    }

    //建立单例
    public static ScreenUtils getInstance(Context context) {
        if (null == screenUtils) {
            screenUtils = new ScreenUtils(context);
        }
        return screenUtils;
    }

    //需要方法 屏幕禁用
    public void setTouchDisable(Activity activity) {

      /*  window=(WindowManager)activity.getSystemService(Context.WINDOW_SERVICE);

        //填充默认的全屏幕布局
        view = LayoutInflater.from(activity).inflate(R.layout.screen_fill_layout, null);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        //设置window type
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        params.format=1;
//        mWindowViewParams.type = LayoutParams.TYPE_APPLICATION;
        //设置全屏flag
        params.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        //调整悬浮窗显示的停靠位置为左侧置顶
        params.gravity = Gravity.LEFT | Gravity.TOP;
        // 以屏幕左上角为原点，设置x、y初始值，相对于gravity
        params.x = 0;
        params.y = 0;
        //设置悬浮窗口长宽数据
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        //设置背景透明
        params.format = PixelFormat.RGBA_8888;
        window.addView(view,params);
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN+View.SYSTEM_UI_FLAG_HIDE_NAVIGATION+View.SYSTEM_UI_FLAG_IMMERSIVE);*/
        window = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        //填充默认的全屏幕布局
        view = LayoutInflater.from(activity).inflate(R.layout.screen_fill_layout, null);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        window.addView(view, params);
    }
    //需要方法 三大键禁用
    public boolean screenDeNy(int keyCode,KeyEvent keyEvent){
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
            case KeyEvent.KEYCODE_HOME:
            case KeyEvent.KEYCODE_MENU:
            case KeyEvent.KEYCODE_VOLUME_DOWN:
            case KeyEvent.KEYCODE_VOLUME_UP:
            case KeyEvent.KEYCODE_VOLUME_MUTE:
                return true;
            default:
                return false;
        }
    }

    //需要方法 屏幕解禁
    public void openScreen() {
        if (null != window && null != view) {
            window.removeView(view);
        }
    }
    //屏幕截屏

}
