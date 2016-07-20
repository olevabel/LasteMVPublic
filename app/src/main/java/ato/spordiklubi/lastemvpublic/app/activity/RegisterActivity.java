package ato.spordiklubi.lastemvpublic.app.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ato.spordiklubi.lastemvpublic.R;
import ato.spordiklubi.lastemvpublic.app.fragment.RegisterFragment;

public class RegisterActivity extends BaseActivity {

    private static final String TAG_REGISTER_FRAGMENT = RegisterActivity.class.getName() + ".TAG_REGISTER_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupRegisterFragment();
    }

    protected void setupRegisterFragment() {
        setupFragment(TAG_REGISTER_FRAGMENT, R.id.layout_register_fragment_container);
    }

    @Override
    protected Fragment createFragment(String tag) {
        if(tag.equals(TAG_REGISTER_FRAGMENT)) {
            return RegisterFragment.newInstance();
        }
        return null;
    }
}

