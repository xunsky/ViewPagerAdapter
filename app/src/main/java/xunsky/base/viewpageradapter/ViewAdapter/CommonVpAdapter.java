package xunsky.base.viewpageradapter.ViewAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by junx on 2017/11/14.
 */

public abstract class CommonVpAdapter<T> extends PagerAdapter {
    //构造器相关
    public Context mContext;
   	public ArrayList<T> mDatas;
    public ArrayList<CharSequence> mTitles;
    public CommonVpAdapter(Context context, ArrayList<T> datas) {
        mContext = context;
        mDatas = datas;
    }
    public CommonVpAdapter(Context context, ArrayList<T> datas, ArrayList<CharSequence> titles) {
        mContext = context;
        mDatas = datas;
        mTitles = titles;
    }
    //通用操作
    @Override
    public int getCount() {
        return mDatas==null?0:mDatas.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view =getView(container,mDatas.get(position),position);
        container.addView(view);//核心步骤,添加了以后视图才会出现在ViewPager中
        return view;
    }
    abstract View getView(ViewGroup container, T data, int position);//初始化view
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles!=null&mTitles.size()!=0){
            return mTitles.get(position);
        }
        return super.getPageTitle(position);
    }
}
