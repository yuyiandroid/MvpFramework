package showdo.mvpframework;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import showdo.mvpframework.internal.di.components.ApplicationComponent;
import showdo.mvpframework.internal.di.components.DaggerApplicationComponent;
import showdo.mvpframework.internal.di.modules.ApplicationModule;

/**
 * Created by Administrator on 2016/6/24.
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    public static List<Activity> sActivities = new LinkedList<>();

    private ApplicationComponent mApplicationComponent;

    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initializeInjector();
        initRetrofit();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://ip.taobao.com/")  // TODO 线下
                //.baseUrl("https://xdapi1.beta.xiudou.net")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public ApplicationComponent getApplicationComponent() {
        return this.mApplicationComponent;
    }

    private void initializeInjector() {
        this.mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public void finishApp() {
        for (Activity activity : sActivities) {
            activity.finish();
        }
        System.exit(0);
    }

    public void addActivity(Activity activity) {
        sActivities.add(activity);
    }

    public void remove(Activity activity) {
        if (sActivities.contains(activity)) {
            sActivities.remove(activity);
        }
    }

}
