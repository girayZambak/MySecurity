package tr.mysecurity.managedBeans.menuFragment;/**
 * Created by NgocTri on 10/18/2015.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tr.mysecurity.R;


public class PersonsFragment extends Fragment {
    public PersonsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.persons_fragment, container, false);

        return rootView;
    }
}
