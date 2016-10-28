package showdo.mvpframework;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import retrofit2.Retrofit;
import showdo.mvpframework.internal.di.components.ApplicationComponent;
import showdo.mvpframework.internal.di.modules.ActivityModule;

/**
 * Created by Administrator on 2016/6/24.
 */
public class BaseActivity extends FragmentActivity {
    public MyApplication mApplication = MyApplication.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        mApplication.remove(this);
        super.onDestroy();
    }

    public ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }

    public Retrofit getRetrofit() {
        return ((MyApplication) getApplication()).getRetrofit();
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
