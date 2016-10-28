package showdo.mvpframework.persenter;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;
import showdo.mvpframework.data.bean.CityBean;
import showdo.mvpframework.interactor.BaseCase;
import showdo.mvpframework.view.MainView;

/**
 * Created by Administrator on 2016/6/24.
 */
public class MainPresenter implements Presenter {

    private BaseCase mBaseCase;
    private MainView mMainView;

    @Inject
    public MainPresenter(@Named("MainCase") BaseCase baseCase) {
        this.mBaseCase = baseCase;
    }

    public void setView(@NonNull MainView mainView) {
        this.mMainView = mainView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pauser() {

    }

    @Override
    public void destroy() {
        this.mBaseCase.unsubscribe();
        this.mBaseCase = null;
    }

    public void loadData() {
        this.mBaseCase.execute(new MainSubscriber());
    }

    public void setMap(Map<String, Object> map) {
        this.mBaseCase.setMap(map);
    }

    private final class MainSubscriber extends Subscriber<CityBean> {
        @Override
        public void onCompleted() {
            Log.i("app_log", "+++++++++++011");
            MainPresenter.this.mMainView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            Log.i("app_log", "+++++++++++02");
            e.printStackTrace();
        }

        @Override
        public void onNext(CityBean cityBean) {
            Log.i("app_log", "+++++++++++03-----" + cityBean.getCode());
            MainPresenter.this.mMainView.updateView(cityBean);
        }
    }
}
