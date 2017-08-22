package fengjw.com.recyclerviewdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends SingleFragmentActivity {

    private static final String TGA = "MainActivity";

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    public Fragment creatFragment() {
        Log.d(TGA, "creatFragment");
        return new NodeListFragment();
    }
}
