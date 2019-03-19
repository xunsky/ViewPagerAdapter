package xunsky.base.viewpageradapter.FragmentAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by junx on 2017/11/14.
 */

public class VpFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> mDatas;
    List<CharSequence> mTitles;

    public VpFragmentAdapter(FragmentManager fm, List<Fragment> datas) {
        this(fm,datas,null);
    }

    public VpFragmentAdapter(FragmentManager fm, List<Fragment> datas, List<CharSequence> titles) {
        super(fm);
        mDatas = datas;
        mTitles = titles;
    }
    //通用操作
    @Override
    public int getCount() {
        return mDatas!=null?mDatas.size():0;
    }
    @Override
    public Fragment getItem(int position) {
        return mDatas!=null?mDatas.get(position):null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles!=null&mTitles.size()!=0){
            return mTitles.get(position);
        }
        return super.getPageTitle(position);
    }
    //datas相关
    public List<Fragment> getDatas() {
        return mDatas;
    }
    public void setDatas(List<Fragment> datas) {
        mDatas = datas;
    }
    public List<CharSequence> getTitles() {
        return mTitles;
    }
    public void setTitles(List<CharSequence> titles) {
        mTitles = titles;
    }
}
