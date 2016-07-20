package ato.spordiklubi.lastemvpublic.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ato.spordiklubi.lastemvpublic.R;

public class RegisterFragment extends BaseFragment {

    private View rootView;
    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_register, container, false);

        return rootView;
    }
}
