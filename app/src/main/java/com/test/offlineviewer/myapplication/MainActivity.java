package com.test.offlineviewer.myapplication;


import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SQLiteHelper sqLiteHelper= new SQLiteHelper(this);
        setContentView(R.layout.activity_main);
        Spinner spinnerLanguages = (Spinner) findViewById(R.id.names);

        spinnerLanguages.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, sqLiteHelper.getdataFromDb()));
        ((ArrayAdapter<?>)spinnerLanguages.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
}


