package ca.stefanm.sayhi.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ca.stefanm.sayhi.R;
import ca.stefanm.sayhi.model.restpojo.Profile;
import ca.stefanm.sayhi.services.CredentialService;

/**
 * Created by stefan on 9/10/15.
 */
public class LoginDebugDialog extends DialogFragment {
    private View view;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        view = inflater.inflate(R.layout.debugdialog_loginstatus, (ViewGroup) getView());


        builder.setView(view)
                .setTitle("Login Status Debug")
                // Add action buttons
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Do nothing
                    }
                });
        return builder.create();
    }

    public void onResume(){
        super.onResume();
        //Populate all the TextViews here.
        CredentialService cs = CredentialService.getInstance();

        switch (cs.getAuthType()){
            case BASIC:
                ((TextView) view.findViewById(R.id.ddlog_authtype)).setText("Basic");
                break;
            case GOOGLE:
                ((TextView) view.findViewById(R.id.ddlog_authtype)).setText("Google");
                break;
        }

        ((TextView)view.findViewById(R.id.ddlog_username))
                .setText(cs.getCredentials().get("username"));
        ((TextView)view.findViewById(R.id.ddlog_password))
                .setText(cs.getCredentials().get("password"));

        if (cs.getAuthenticated()){
            ((TextView)view.findViewById(R.id.ddlog_authstatus))
                    .setText("True");
        } else {
            ((TextView)view.findViewById(R.id.ddlog_authstatus))
                    .setText("False");
        }

        try {
            ((TextView) view.findViewById(R.id.ddlog_prf))
                    .setText(cs.getMyProfile().toString());
        } catch (NullPointerException e){
            ((TextView) view.findViewById(R.id.ddlog_prf))
                    .setText("Null");
        }

    }

}
