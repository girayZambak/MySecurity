package tr.mysecurity.managedBeans.menuFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tr.mysecurity.R;
import tr.mysecurity.gcm.SendGcmService;


public class MainPageFragment extends Fragment {
    public MainPageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.main_page_fragment, container, false);

        Button btnLogOut = (Button) rootView.findViewById(R.id.btnSend);
        btnLogOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Sending Message
                SendGcmService.getInstance(container.getContext()).sendToGcm();
            }
        });

        return rootView;
    }
}
