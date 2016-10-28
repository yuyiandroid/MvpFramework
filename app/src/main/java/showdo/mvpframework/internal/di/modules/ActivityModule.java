package showdo.mvpframework.internal.di.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import showdo.mvpframework.internal.di.PerActivity;

/**
 * Created by Administrator on 2016/6/24.
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return mActivity;
    }

}
