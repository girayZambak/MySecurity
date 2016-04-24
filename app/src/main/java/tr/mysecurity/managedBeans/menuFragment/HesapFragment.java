package tr.mysecurity.managedBeans.menuFragment;/**
 * Created by NgocTri on 10/18/2015.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tr.mysecurity.R;
import tr.mysecurity.business.UserService;
import tr.mysecurity.dao.UserDao;
import tr.mysecurity.util.Authentication;


public class HesapFragment extends Fragment {
    public HesapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hesap_fragment, container, false);

        Button btnLogOut = (Button) rootView.findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UserService userService = new UserService();
                userService.logOut(container.getContext());
                new Authentication().reLocate(container.getContext());

            }
        });
        Button btnDeleteUser = (Button) rootView.findViewById(R.id.btnDeleteUser);
        btnDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDao userDao = new UserDao(container.getContext());
                userDao.resetTable();
                new Authentication().reLocate(container.getContext());
            }
        });

        return rootView;
    }
}
