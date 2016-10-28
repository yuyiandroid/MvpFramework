package showdo.mvpframework;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.widget.TextView;

import java.util.Map;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import showdo.mvpframework.data.bean.CityBean;
import showdo.mvpframework.data.service.module.MyServiceModule;
import showdo.mvpframework.internal.di.components.DaggerMainComponent;
import showdo.mvpframework.internal.di.components.MainComponent;
import showdo.mvpframework.internal.di.modules.MainModule;
import showdo.mvpframework.persenter.MainPresenter;
import showdo.mvpframework.view.MainView;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class MainActivity extends BaseActivity implements MainView {

    @InjectView(R.id.textview)
    TextView mTextView;

    MainComponent mMainComponent;
    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initializeInjector();
        this.mMainPresenter.setView(this);
        Map<String, Object> map = new ArrayMap<>();
        map.put("ip", "21.22.11.33");
        mMainPresenter.setMap(map);
        mMainPresenter.loadData();
    }

    public void initializeInjector() {
        Map<String, Object> map = new ArrayMap<>();
        this.mMainComponent = DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .myServiceModule(new MyServiceModule(getRetrofit()))
                .mainModule(new MainModule(map))
                .build();
        this.mMainComponent.inject(this);
    }

    @OnClick(R.id.textview)
    void onClick(){


    }

    @Override
    public void updateView(CityBean cityBean) {
        mTextView.setText(cityBean.getData().getCountry());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public Context context() {
        return MainActivity.this;
    }
}
