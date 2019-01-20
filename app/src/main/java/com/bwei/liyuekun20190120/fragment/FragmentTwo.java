package com.bwei.liyuekun20190120.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwei.liyuekun20190120.R;

public class FragmentTwo extends Fragment {
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_two, container, false);
        imageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotationY", 0, 180);
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1, 2);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1, 2);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(rotation).with(scaleX).with(scaleY);
                animatorSet.setDuration(3000);
                animatorSet.start();
            }
        });
    }
}
