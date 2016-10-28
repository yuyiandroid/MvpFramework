package showdo.mvpframework.internal.di.modules;

import java.util.Map;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import showdo.mvpframework.data.service.RetrofitService;
import showdo.mvpframework.interactor.BaseCase;
import showdo.mvpframework.interactor.MainCase;
import showdo.mvpframework.internal.di.PerActivity;

/**
 * Created by Administrator on 2016/6/24.
 */
@Module
public class MainModule {

    private Map<String, Object> map;

    public MainModule() {

    }

    public MainModule(Map<String, Object> map) {
        this.map = map;
    }

    @PerActivity
    @Provides
    @Named("MainCase")
    BaseCase providerMainCase(RetrofitService retrofitService) {
        return new MainCase(map,retrofitService);
    }
}
