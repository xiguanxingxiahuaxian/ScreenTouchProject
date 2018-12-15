package unit.tool.com.screentouchproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import unit.tool.com.screentouchproject.R;

/**
 * 项目名称：ScreenTouchProject
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2018/12/14 17:20
 * 修改备注
 */
public class RegisterActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_fill_layout);
        initView();
    }

    private void initView() {

    }
    @Override
    public void onAttachedToWindow() {
        this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        super.onAttachedToWindow();
    }
}
