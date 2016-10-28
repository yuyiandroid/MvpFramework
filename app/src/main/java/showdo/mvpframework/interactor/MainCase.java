package showdo.mvpframework.interactor;

import java.util.Map;

import rx.Observable;
import showdo.mvpframework.data.service.RetrofitService;

/**
 * Created by Administrator on 2016/6/24.
 * 提供Observable(被观察者 事件源)
 */
public class MainCase extends BaseCase {

    private RetrofitService mRetrofitService;

    public MainCase(Map<String, Object> map, RetrofitService retrofitService) {
        this.map = map;
        this.mRetrofitService = retrofitService;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mRetrofitService.getCity(map);
    }
}
