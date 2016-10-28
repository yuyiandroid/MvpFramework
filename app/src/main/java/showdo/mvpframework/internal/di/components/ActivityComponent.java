package showdo.mvpframework.internal.di.components;

import android.app.Activity;

import dagger.Component;
import showdo.mvpframework.internal.di.PerActivity;
import showdo.mvpframework.internal.di.modules.ActivityModule;

/**
 * Created by Administrator on 2016/6/24.
 */
//dependencies 依赖性

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity activity();
}
