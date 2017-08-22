package fengjw.com.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by fengjw on 2017/8/21.
 */

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecycleView;

    private List<Crime> mCrimes;

    public CrimeAdapter(List<Crime> crimes){
        mCrimes = crimes;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        return null;
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

}
