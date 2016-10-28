package showdo.mvpframework.internal.di.components;

import dagger.Component;
import showdo.mvpframework.MainActivity;
import showdo.mvpframework.data.service.module.MyServiceModule;
import showdo.mvpframework.internal.di.PerActivity;
import showdo.mvpframework.internal.di.modules.ActivityModule;
import showdo.mvpframework.internal.di.modules.MainModule;

/**
 * Created by Administrator on 2016/6/24.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = {ActivityModule.class, MainModule.class, MyServiceModule.class})
public interface MainComponent {
    
    void inject(MainActivity mainActivity);
}
