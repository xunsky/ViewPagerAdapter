package xunsky.base.viewpageradapter.FragmentAdapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.Random;

public class BlankFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public BlankFragment() {
    }

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout view = new FrameLayout(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
                ,FrameLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        int i = new Random().nextInt(5);
        int color=0;
        switch (i){
            case 0:
                color= Color.RED;
                break;
            case 1:
                color=Color.BLUE;
                break;
            case 2:
                color=Color.GREEN;
                break;
            case 3:
                color=Color.YELLOW;
                break;
            case 4:
                color=Color.BLACK;
                break;
            case 5:
                color=Color.GRAY;
                break;
        }
        view.setBackgroundColor(color);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //在Viewpager中使用时,这里可以作为在页面展示时的回调
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
