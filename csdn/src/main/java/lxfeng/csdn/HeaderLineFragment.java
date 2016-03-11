package lxfeng.csdn;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import lxfeng.myapplication.ImageLoader;

public class HeaderLineFragment extends BaseFragment {

    private static final String URL =
            "http://img03.sogoucdn.com/app/a/100520024/7a46a6353a8e0b33ed3f5e15bdde2091";

    private ImageView mTestImg;

    public static HeaderLineFragment newInstance() {
        HeaderLineFragment fragment = new HeaderLineFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_header_line, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTestImg = (ImageView) view.findViewById(R.id.img_test);
        ImageLoader.getInstance().displayImage(URL, mTestImg);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
