package unit.tool.com.screentouchproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import unit.tool.com.screentouchcontroller.utils.ScreenUtils;

/**
 * 项目名称：ScreenTouchProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2018/12/13 16:56
 * 修改备注
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }


    private void initView() {
        /**
         * 禁用touch
         * demo测试崩溃，需要注掉此方法
         */
        ScreenUtils.getInstance(getApplicationContext()).setTouchDisable(this);
    }

    //禁用一些按键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return ScreenUtils.getInstance(this).screenDeNy(keyCode, event);
    }

}
