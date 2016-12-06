package com.cyl.music_hnust.fragment.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cyl.music_hnust.activity.MainActivity;
import com.cyl.music_hnust.service.PlayService;
import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * 作者：YongLong on 2016/8/8 16:58
 * 邮箱：643872807@qq.com
 * 版本：2.5
 */
public abstract class BaseFragment extends RxFragment {
    private PlayService mPlayService;
    protected static Handler mHandler;
    private boolean mResumed;
    public View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        mHandler = new Handler();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initViews();
        initDatas();
        listener();
        mResumed = true;
    }

    protected abstract void listener();

    protected abstract void initDatas();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof MainActivity) {
            mPlayService = ((MainActivity) activity).getmPlayService();
        }
    }

    @Override
    public void onDetach() {

        super.onDetach();
    }

    public abstract int getLayoutId();

    public abstract void initViews();

    public PlayService getmPlayService() {
        return mPlayService;
    }
    public boolean isResume() {
        return mResumed;
    }
}
