package xunsky.base.viewpageradapter.ViewAdapter.VpHolderAdapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junx on 2017/11/14.
 */

public abstract class VpAdapter<T> extends PagerAdapter {
    //构造器相关
    public Context mContext;
    public List<T> mDatas;
    public List<CharSequence> mTitles;
    public int mLayoutId = -1;
    LayoutInflater mInflater;

    public VpAdapter(Context context, List<T> datas, @LayoutRes int layoutId) {
        mContext = context;
        mDatas = datas;
        mLayoutId = layoutId;
        mInflater = LayoutInflater.from(context);
    }

    public VpAdapter(Context context, ArrayList<T> datas, @IdRes int layoutId, ArrayList<CharSequence> titles) {
        mContext = context;
        mDatas = datas;
        mLayoutId = layoutId;
        mTitles = titles;
        mInflater = LayoutInflater.from(context);
    }

    //通用操作
    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mLayoutId == -1) {
            throw new RuntimeException("请传入布局");
        }
        View root = mInflater.inflate(mLayoutId, container, false);
        getView(new VpCommonViewHolder(root),mDatas.get(position),position);
        container.addView(root);//核心步骤,添加了以后视图才会出现在ViewPager中
        return root;
    }

    public abstract void getView(VpCommonViewHolder holder, T data, int position);
    public void setDatas(List<T> datas){
       mDatas=datas;
       notifyDataSetChanged();
    }
    public void addData(T data){
        if (mDatas==null){
            mDatas=new ArrayList<>();
        }
        mDatas.add(data);
        notifyDataSetChanged();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null & mTitles.size() != 0) {
            return mTitles.get(position);
        }
        return super.getPageTitle(position);
    }
}
