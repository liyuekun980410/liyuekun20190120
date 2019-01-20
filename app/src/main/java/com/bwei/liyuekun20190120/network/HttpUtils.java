package com.bwei.liyuekun20190120.network;

import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import com.bwei.liyuekun20190120.LoginActivity;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {

    private final OkHttpClient client;
    private static volatile HttpUtils instance;
    public Handler handler=new Handler();

    private Interceptor getAppInterceptor() {
        Interceptor interceptor = new Interceptor(){
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Log.e("++++++","拦截前");
                Response response = chain.proceed(request);
                Log.e("++++++","拦截后");
                return response;
            }
        };
        return interceptor;
    }
    private HttpUtils(){
        File file = new File(Environment.getExternalStorageDirectory(), "cache11");
        client = new OkHttpClient.Builder()
                .readTimeout(3000, TimeUnit.SECONDS)
                .connectTimeout(3000, TimeUnit.SECONDS)
                .cache(new Cache(file, 10 * 1024))
                .addInterceptor(getAppInterceptor())
                .build();
    }
    //单例okhttp
    public static HttpUtils getInstance(){
        if (instance==null){
            synchronized (HttpUtils.class){
                if (null==instance){
                    instance=new HttpUtils();
                }
            }
        }
        return instance;
    }

    public void doGet(String url, final Class clazz, final NetCallBack netCallBack){
        final Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.Failure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(result, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        netCallBack.Success(o);
                    }
                });
            }
        });
    }
    public interface NetCallBack{
        void Success(Object o);
        void Failure(Exception e);
    }
}
