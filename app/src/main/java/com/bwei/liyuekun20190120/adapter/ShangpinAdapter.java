package com.bwei.liyuekun20190120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.liyuekun20190120.CountView;
import com.bwei.liyuekun20190120.R;
import com.bwei.liyuekun20190120.bean.ShopBean;

import org.w3c.dom.Text;

import java.util.List;

public class ShangpinAdapter extends RecyclerView.Adapter<ShangpinAdapter.ViewHolder> {

    Context context;
    List<ShopBean.DataBean.ListBean> listBeans;
    LayoutInflater inflater;

    public ShangpinAdapter(Context context, List<ShopBean.DataBean.ListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.layout_shangpin, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(listBeans.get(i).getImages().split("\\|")[0].replace("https","http")).into(viewHolder.spimage);
        viewHolder.sptitle.setText(listBeans.get(i).getTitle());
        viewHolder.spprice.setText(listBeans.get(i).getPrice());
        viewHolder.count_view.setData(this,listBeans,i);
        viewHolder.count_view.setOnCallBack(new CountView.CallBackListener() {
            @Override
            public void callBack() {
                if (shangCallBack!=null){
                    shangCallBack.CallBack();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox spcheck;
        private final ImageView spimage;
        private final TextView sptitle;
        private final TextView spprice;
        private final CountView count_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            spcheck = itemView.findViewById(R.id.spcheck);
            spimage = itemView.findViewById(R.id.spimage);
            sptitle = itemView.findViewById(R.id.sptitle);
            spprice = itemView.findViewById(R.id.spprice);
            count_view = itemView.findViewById(R.id.count_view);
        }
    }

    private ShangCallBack shangCallBack;
    public void setOnCallBack(ShangCallBack shangCallBack){
        this.shangCallBack=shangCallBack;
    }
    public interface ShangCallBack{
        void CallBack();
    }
}
