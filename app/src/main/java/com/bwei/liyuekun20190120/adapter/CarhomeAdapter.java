package com.bwei.liyuekun20190120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwei.liyuekun20190120.R;
import com.bwei.liyuekun20190120.bean.ShopBean;

import org.w3c.dom.Text;

import java.util.List;

public class CarhomeAdapter extends RecyclerView.Adapter<CarhomeAdapter.ViewHolder> {
    Context context;
    ShopBean shopBean;
    List<ShopBean.DataBean> list;
    LayoutInflater inflater;

    public CarhomeAdapter(Context context, ShopBean shopBean) {
        this.context = context;
        this.shopBean = shopBean;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.layout_shangjia, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.shangjia.setText(shopBean.getData().get(i).getSellerName());
        list=shopBean.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        viewHolder.sprecycle.setLayoutManager(linearLayoutManager);
        ShangpinAdapter shangpinAdapter = new ShangpinAdapter(context,list.get(i).getList());
        viewHolder.sprecycle.setAdapter(shangpinAdapter);
    }

    @Override
    public int getItemCount() {
        return shopBean.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox sjcheck;
        private final TextView shangjia;
        private final RecyclerView sprecycle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sjcheck = itemView.findViewById(R.id.sjcheck);
            shangjia = itemView.findViewById(R.id.shangjia);
            sprecycle = itemView.findViewById(R.id.sprecycle);
        }
    }
}
