package ato.spordiklubi.lastemvpublic.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ato.spordiklubi.lastemvpublic.R;
import ato.spordiklubi.lastemvpublic.app.activity.RegisterActivity;

public class MainFragment extends BaseFragment {

    private View rootView;
    private TextView btnLookResults;
    private TextView btnRegister;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        btnLookResults = (TextView) rootView.findViewById(R.id.btn_look_results);
        btnRegister = (TextView) rootView.findViewById(R.id.btn_register);

        btnLookResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
