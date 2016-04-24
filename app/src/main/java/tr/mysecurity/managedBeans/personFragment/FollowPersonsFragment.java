package tr.mysecurity.managedBeans.personFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tr.mysecurity.R;


public class FollowPersonsFragment extends Fragment {


    public FollowPersonsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.follow_persons_fragment, container, false);
        return rootView;
    }
}
