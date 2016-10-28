package showdo.mvpframework.data.service;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;
import showdo.mvpframework.data.bean.CityBean;

/**
 * Created by Administrator on 2016/6/24.
 */

//测试接口：http://ip.taobao.com/service/getIpInfo.php?ip=21.22.11.33
public interface RetrofitService {
    //动态代理对象
    //返回一个Observable(被观察者，事件源 交给观察者处理)

//    @GET("service/getIpInfo.php")
//    Observable<CityBean> getCity(@Query("ip") String ip);

    @GET("service/getIpInfo.php")
    Observable<CityBean> getCity(@QueryMap Map<String,Object> map);

    //@GET("user/sign_in.json")
    //Observable<CityBean> getCity(@QueryMap Map<String, Object> map);//配合RxJava写法
}
