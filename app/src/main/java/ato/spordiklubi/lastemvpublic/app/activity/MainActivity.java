package ato.spordiklubi.lastemvpublic.app.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ato.spordiklubi.lastemvpublic.R;
import ato.spordiklubi.lastemvpublic.app.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG_FRAGMENT_MAIN = MainActivity.class.getName() + ".TAG_FRAGMENT_MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMainFragment();
    }

    protected void setupMainFragment() {
        setupFragment(TAG_FRAGMENT_MAIN, R.id.layout_main_fragment_container);
    }

    @Override
    protected Fragment createFragment(final String tag) {
        if (tag.equals(TAG_FRAGMENT_MAIN)) {

            return MainFragment.newInstance();
        }
        return null;
    }
}
