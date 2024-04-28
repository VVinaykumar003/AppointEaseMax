package com.example.appointeasemax;

import static com.example.appointeasemax.R.layout.activity_notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.res.ResourcesCompat;

public class Notificationn extends AppCompatActivity {
    private static final String CHANNEL_ID = "Remainder";

    private static final int NOTIFICATION_ID = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(activity_notification);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.app_logo,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon =bitmapDrawable.getBitmap();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification remainder;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1)  {

            remainder = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.app_logo)
                    .setContentText("Remainder")
                    .setSubText("YOur appointment is here")
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel",NotificationManager.IMPORTANCE_DEFAULT));

        }else{
            remainder = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.app_logo)
                    .setContentText("Remainder")
                    .setSubText("YOur appointment is here")
                    .build();

        }

        nm.notify(NOTIFICATION_ID,remainder);
    }
}