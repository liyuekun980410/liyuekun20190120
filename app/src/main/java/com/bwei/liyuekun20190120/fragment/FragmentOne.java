package com.bwei.liyuekun20190120.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.liyuekun20190120.R;
import com.bwei.liyuekun20190120.adapter.CarhomeAdapter;
import com.bwei.liyuekun20190120.bean.ShopBean;
import com.bwei.liyuekun20190120.shopcar.presenter.Presneterimpl;
import com.bwei.liyuekun20190120.shopcar.view.IView;

public class FragmentOne extends Fragment implements IView {
    private RecyclerView recycle_view;
    private Presneterimpl presneterimpl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_one, container, false);
        recycle_view = view.findViewById(R.id.recycle_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recycle_view.setLayoutManager(linearLayoutManager);
        presneterimpl = new Presneterimpl(this);
        presneterimpl.getPresentData();
    }

    @Override
    public void getViewData(Object obj) {
        ShopBean shopBean= (ShopBean) obj;
        CarhomeAdapter carhomeAdapter = new CarhomeAdapter(getContext(),shopBean);
        recycle_view.setAdapter(carhomeAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presneterimpl!=null){
            presneterimpl.onDestory();
        }
    }
}
