package com.example.musicplayerapp.Class;

import static com.example.musicplayerapp.Class.ApplicationClass.ACTION_NEXT;
import static com.example.musicplayerapp.Class.ApplicationClass.ACTION_PLAY;
import static com.example.musicplayerapp.Class.ApplicationClass.ACTION_PREVIOUS;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.musicplayerapp.Fragment.MusicService;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String actionName = intent.getAction();
        Intent serviceIntent = new Intent(context, MusicService.class);
        if(actionName != null){
            switch (actionName){
                case ACTION_PLAY:
                    serviceIntent.putExtra("ActionName", "playPause");
                    context.startService(serviceIntent);
                    break;
                case ACTION_NEXT:
                    serviceIntent.putExtra("ActionName", "next");
                    context.startService(serviceIntent);
                    break;
                case ACTION_PREVIOUS:
                    serviceIntent.putExtra("ActionName", "previous");
                    context.startService(serviceIntent);
                    break;
            }
        }
    }
}
