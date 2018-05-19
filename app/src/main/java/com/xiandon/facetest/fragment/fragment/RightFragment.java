package com.xiandon.facetest.fragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiandon.facetest.R;


public class RightFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_simple_right, container, false);
        Log.d(TAG, "onCreateView 创建View");
        return view;
    }

    private static String TAG = "右边Fragmen ";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach 连接");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate 创建");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated 活动创建");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart 开始");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume 恢复");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause 暂停");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop 停止");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView 销毁View");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy 销毁");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach 分离");
    }
}
