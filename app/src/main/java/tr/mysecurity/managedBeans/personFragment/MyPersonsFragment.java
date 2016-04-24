package tr.mysecurity.managedBeans.personFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tr.mysecurity.R;


public class MyPersonsFragment extends Fragment {
    public MyPersonsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_persons_fragment, container, false);
        return view;
    }
}
