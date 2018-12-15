### 提供方法
1 屏幕锁定

2 屏幕屏蔽按键  三大键

    //提供基础baseActivity 框架中需要继承此方式
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

3 类似守护线程，使用android 方式来实现crash 重新拉起服务
  
    //提供application 调用方法
    @Override
    public void onCreate() {
        super.onCreate();
        //demo 测试方案  线程设置监控
        CrashHelpUtils.getInstance().RegisterApp(this, "unit.tool.com.screentouchproject.MainActivity");
    }

