package fengjw.com.criminalintent;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by fengjw on 2017/8/21.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    private static final String TGA = "CrimeListActivity";

    @Override
    protected Fragment createFragment() {
        Log.d(TGA, "createFragment");
        return new CrimeListFragment();
    }
}
