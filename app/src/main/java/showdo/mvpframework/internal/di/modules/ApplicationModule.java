package showdo.mvpframework.internal.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import showdo.mvpframework.MyApplication;

/**
 * Created by Administrator on 2016/6/24.
 */
@Module
public class ApplicationModule {
    private final MyApplication mApplication;

    public ApplicationModule(MyApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.mApplication;
    }
}

