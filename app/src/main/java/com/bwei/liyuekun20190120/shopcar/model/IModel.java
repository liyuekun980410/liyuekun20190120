package com.bwei.liyuekun20190120.shopcar.model;

public interface IModel {
    public void getModelData(String url,IModelinterface iModelinterface);
    interface IModelinterface{
        void onSucess(Object o);
        void onFail();
    }
}
