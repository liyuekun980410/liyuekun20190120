package com.bwei.liyuekun20190120.shopcar.model;

import com.bwei.liyuekun20190120.bean.ShopBean;
import com.bwei.liyuekun20190120.network.HttpUtils;

public class Modelimpl implements IModel{
    @Override
    public void getModelData(String url, final IModelinterface iModelinterface) {
        HttpUtils.getInstance().doGet(url, ShopBean.class, new HttpUtils.NetCallBack() {
            @Override
            public void Success(Object o) {
                iModelinterface.onSucess(o);
            }

            @Override
            public void Failure(Exception e) {
                iModelinterface.onFail();
            }
        });
    }
}
