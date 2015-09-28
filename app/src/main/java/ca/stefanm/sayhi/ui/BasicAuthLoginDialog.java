package ca.stefanm.sayhi.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import ca.stefanm.sayhi.R;
import ca.stefanm.sayhi.SplashActivity;

/**
 * Created by stefan on 9/27/15.
 */
public class BasicAuthLoginDialog extends DialogFragment {

    private View view;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        view = inflater.inflate(R.layout.dialog_basiclogin, (ViewGroup) getView());
        builder.setView(view)
                .setTitle("Login to SayHi")
                        // Add action buttons
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Get the information from the text field and do a basic login

                        EditText et_username = (EditText)view.findViewById(R.id.login_basic_username);
                        String username = et_username.getText().toString();

                        EditText et_password = (EditText)view.findViewById(R.id.login_basic_password);
                        String password = et_password.getText().toString();

                        ((SplashActivity)getActivity()).BasicAuthLoginCallback(username, password);


                    }
                })
                .setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Do nothing.
                    }
                });
        return builder.create();
    }

    public void onResume(){
        super.onResume();
        //Populate all the TextViews here.
    }
}
