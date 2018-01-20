package com.sunztech.admin.general_app.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunztech.admin.general_app.R;
import com.sunztech.admin.general_app.widget.view.TestTouchView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TouchEventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TouchEventFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TestTouchView view1,view2;


    public TouchEventFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TouchEventFragment newInstance(String param1, String param2) {
        TouchEventFragment fragment = new TouchEventFragment();
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
        return inflater.inflate(R.layout.fragment_touch_event, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view1 = (TestTouchView) view.findViewById(R.id.view1);
        view2 = (TestTouchView) view.findViewById(R.id.view2);
        view1.setTag("view1");
        view2.setTag("view2");
        /*view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("onTouch","---------------------view1");
                return true;
            }
        });
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.i("onTouch","---------------------view2");
                return true;
            }
        });*/
        /*view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("onClick","---------------------view2");
            }
        });*/
    }
}
