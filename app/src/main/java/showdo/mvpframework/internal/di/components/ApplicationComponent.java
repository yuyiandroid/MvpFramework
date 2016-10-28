package showdo.mvpframework.internal.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import showdo.mvpframework.BaseActivity;
import showdo.mvpframework.internal.di.modules.ApplicationModule;

/**
 * Created by Administrator on 2016/6/24.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
}
