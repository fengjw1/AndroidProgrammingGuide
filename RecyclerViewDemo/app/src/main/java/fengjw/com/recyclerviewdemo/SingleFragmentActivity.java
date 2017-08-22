package fengjw.com.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fengjw on 2017/8/22.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment creatFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();//使用的是扩展包的FragmentManager
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_main);

        if (fragment == null){
            fragment = creatFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_main, fragment).commit();
        }
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//
//
//    }

//    @Override
//    public View onCreateView(String name, Context context, AttributeSet attrs) {
//        return super.onCreateView(name, context, attrs);
//    }
}
