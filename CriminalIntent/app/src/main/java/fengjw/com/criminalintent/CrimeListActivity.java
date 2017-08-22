package fengjw.com.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by fengjw on 2017/8/21.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
