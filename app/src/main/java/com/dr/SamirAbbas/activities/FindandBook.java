package com.dr.SamirAbbas.activities;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Anurag on 4/9/2018.
 */

public class FindAndBook {
    private String docNameTextView;


    public FindAndBook(String docNameTextView) {
        this.docNameTextView = docNameTextView;

    }

    public String getDocNameTextView() {
        return docNameTextView;
    }

    public void setDocNameTextView(String docNameTextView) {
        this.docNameTextView = docNameTextView;
    }


}
