package com.bwei.liyuekun20190120;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.liyuekun20190120.adapter.ShangpinAdapter;
import com.bwei.liyuekun20190120.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;

public class CountView extends RelativeLayout implements View.OnClickListener {
    private TextView jia;
    private TextView num;
    private TextView jian;
    private int num1=1;
    Context context;
    private int position;
    List<ShopBean.DataBean.ListBean> list=new ArrayList<>();
    ShangpinAdapter shangpinAdapter;

    public CountView(Context context) {
        super(context);
    }

    public CountView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        View view = View.inflate(context, R.layout.layout_count, null);
        jian = view.findViewById(R.id.jian);
        num = view.findViewById(R.id.num);
        jia = view.findViewById(R.id.jia);
        jian.setOnClickListener(this);
        jia.setOnClickListener(this);
        addView(view);
    }

    public CountView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CountView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jian:
                if (num1>1){
                    num1--;
                }else {
                    Toast.makeText(getContext(),"商品数量不能小于1",Toast.LENGTH_SHORT).show();
                }
                num.setText(num1+"");
                list.get(position).setNum(num1+"");
                callBackListener.callBack();
                break;
            case R.id.jia:
                num1++;
                num.setText(num1+"");
                list.get(position).setNum(num1+"");
                callBackListener.callBack();
                break;
            default:
                break;
        }
    }

    public void setData(ShangpinAdapter shangpinAdapter,List<ShopBean.DataBean.ListBean> list, int i){
        this.list=list;
        this.shangpinAdapter=shangpinAdapter;
        position=i;
        num1=Integer.parseInt(list.get(position).getNum());
        num.setText(this.num1+"");
    }

    private CallBackListener callBackListener;
    public void setOnCallBack(CallBackListener listener){
        this.callBackListener=listener;
    }
    public interface CallBackListener{
        void callBack();
    }
}
