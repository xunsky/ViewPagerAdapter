package xunsky.base.viewpageradapter.ViewAdapter.VpHolderAdapter;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.TextView;

/**
 * Created by junx on 2017/11/13.
 */

public class VpCommonViewHolder {
    private View convertView;
    public VpCommonViewHolder(View convertView) {
        this.convertView = convertView;
    }
    protected  <T extends View> T findView(@IdRes int id){
    T t = (T) convertView.findViewById(id);
        if (t==null){
            throw new RuntimeException("找不到该id所表示的view");
        }
        return t;
    }

    public <T extends View> T getView(@IdRes int id){
        View v =findView(id);
        return (T) v;
    }

    public TextView setText(@IdRes int resId,CharSequence string){
        TextView tv = getView(resId);
        tv.setText(string);
        return tv;
    }
    public TextView setText(@IdRes int resId){
        TextView tv = getView(resId);
        return tv;
    }
    public View getRootView(){
        return convertView;
    }
}
