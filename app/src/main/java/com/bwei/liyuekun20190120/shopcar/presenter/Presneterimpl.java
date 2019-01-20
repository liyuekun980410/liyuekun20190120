package com.bwei.liyuekun20190120.shopcar.presenter;

import com.bwei.liyuekun20190120.fragment.FragmentOne;
import com.bwei.liyuekun20190120.shopcar.model.IModel;
import com.bwei.liyuekun20190120.shopcar.model.Modelimpl;

public class Presneterimpl implements IPresenter{
    private final Modelimpl modelimpl;
    FragmentOne fragmentOne;

    public Presneterimpl(FragmentOne fragmentOne) {
        this.fragmentOne = fragmentOne;
        modelimpl = new Modelimpl();
    }

    @Override
    public void getPresentData() {
        modelimpl.getModelData("http://www.zhaoapi.cn/product/getCarts?uid=71", new IModel.IModelinterface() {
            @Override
            public void onSucess(Object o) {
                fragmentOne.getViewData(o);
            }

            @Override
            public void onFail() {

            }
        });
    }

    public void onDestory(){
        if (fragmentOne!=null){
            fragmentOne=null;
        }
    }
}
