package com.example.abrivard1.loginactivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DistrictDialog extends Dialog {
    private TextView describe;
    private ImageButton call;

    public DistrictDialog(Context context, String txtDescribeString){
        super(context);
        this.setContentView(R.layout.dialog_district);
        describe=(TextView) findViewById(R.id.dialog_district_description);
        call = (ImageButton) findViewById(R.id.dialog_district_call_btn);

        describe.setText(txtDescribeString);
    }




    public String getDescribe() {
        return String.valueOf(describe.getText());
    }

    public void setDescribe(String describe) {
        this.describe.setText(describe);
    }

    public ImageButton getCall() {
        return call;
    }

    public void setCall(ImageButton call) {
        this.call = call;
    }
}