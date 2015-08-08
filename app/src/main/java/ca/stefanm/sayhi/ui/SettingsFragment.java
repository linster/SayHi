package ca.stefanm.sayhi.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;

import ca.stefanm.sayhi.R;

/**
 * Created by stefan on 8/8/15.
 */
public class SettingsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
}
