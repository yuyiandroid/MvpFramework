package showdo.mvpframework.data.service.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import showdo.mvpframework.data.service.RetrofitService;
import showdo.mvpframework.internal.di.PerActivity;

/**
 * Created by Administrator on 2016/6/24.
 * 提供RetrofitService的Module
 */
@Module
public class MyServiceModule {
    private Retrofit mRetrofit;

    public MyServiceModule(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

    @Provides
    @PerActivity
    RetrofitService getRetrofitService() {
        return mRetrofit.create(RetrofitService.class);
    }
}
