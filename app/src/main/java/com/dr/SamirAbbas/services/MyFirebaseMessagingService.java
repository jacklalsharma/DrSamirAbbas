package com.dr.SamirAbbas.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.activities.SplashActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Anurag on 4/15/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService{

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("VALUE_BODY", remoteMessage.getNotification().getBody());
        Log.d("VALUE_DATA", remoteMessage.getData().toString());

        Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        Uri sound = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/raw/notification");

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        String imageUri = remoteMessage.getData().get("image");
        //If the key AnotherActivity has  value as True then when the user taps on notification, in the app AnotherActivity will be opened.
        //If the key AnotherActivity has  value as False then when the user taps on notification, in the app MainActivity will be opened.
        String TrueOrFlase = remoteMessage.getData().get("AnotherActivity");

        //To get a Bitmap image from the URL received
        Bitmap bitmap = getBitmapfromUrl(imageUri);

        android.support.v4.app.NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "my_channel_01")
                .setContentTitle(remoteMessage.getNotification().getBody())
                .setContentText(remoteMessage.getData().get("message"))
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap))/*Notification with Image*/
                .setAutoCancel(true)
                .setSound(sound)
                .setContentIntent(pendingIntent)
                .setContentInfo("ANY")
                .setLargeIcon(icon)
                .setColor(Color.TRANSPARENT)
                .setSmallIcon(R.mipmap.ic_launcher);


        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
        notificationBuilder.setLights(Color.YELLOW, 1000, 300);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("my_channel_01",
                    "TEST",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(0, notificationBuilder.build());

    }

    public Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }
}
