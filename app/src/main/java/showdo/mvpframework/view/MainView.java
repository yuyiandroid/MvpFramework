package showdo.mvpframework.view;

import showdo.mvpframework.data.bean.CityBean;

/**
 * Created by Administrator on 2016/6/24.
 */
public interface MainView extends LoadDataView {

    void updateView(CityBean cityBean);
}
