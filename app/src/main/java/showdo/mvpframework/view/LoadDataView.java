package showdo.mvpframework.view;

import android.content.Context;

/**
 * Created by Administrator on 2016/6/24.
 */
public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void showError();

    Context context();
}
