package com.dr.SamirAbbas.utils;


import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.TextView;

import com.dr.SamirAbbas.R;


/**
 * Created by Anurag on 24/7/17.
 */
public class DialogBox {

    private static Dialog customProgressDialog;

    private static Dialog messageDialogWithTwoButtons;

    private static Dialog messageDialogWithOneButton;

    /**
     * This method is to show the message dialog box.
     * @param activity
     * @param title
     * @param message
     */
    public static void ShowProgressDialog(Activity activity, String title, String message){
        try{
            if(customProgressDialog != null){
                if(customProgressDialog.isShowing()){
                    customProgressDialog.dismiss();
                }
            }
        }catch (Exception e){

        }

        customProgressDialog = new Dialog(activity, R.style.AppThemeFull);
        customProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customProgressDialog.setContentView(R.layout.progress_dialog_layout);
        customProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView titl = (TextView) customProgressDialog.findViewById(R.id.title);
        titl.setText(title);
        customProgressDialog.setCancelable(false);
        TextView msg = (TextView) customProgressDialog.findViewById(R.id.message);
        msg.setText(message);
        try{
            customProgressDialog.show();
        }catch (Exception e){

        }
    }

    /**
     * This method is to update the title and message on progress dialog...
     * @param newTitle
     * @param newMessage
     */
    public static void UpdateProgressDialogMessage(String newTitle, String newMessage){
        if(customProgressDialog == null){
            return;
        }

        try{
            if(customProgressDialog.isShowing()){
                TextView titl = (TextView) customProgressDialog.findViewById(R.id.title);
                titl.setText(newTitle);

                TextView msg = (TextView) customProgressDialog.findViewById(R.id.message);
                msg.setText(newMessage);
            }
        }catch (Exception e){

        }
    }

    /**
     * This method is to dismiss the dialog box.
     */
    public static void DismissProgressDialog(){
        if(customProgressDialog == null){
            return;
        }
        try {
            if(customProgressDialog.isShowing()){
                customProgressDialog.dismiss();
            }
        }catch (Exception e){

        }
    }



}
