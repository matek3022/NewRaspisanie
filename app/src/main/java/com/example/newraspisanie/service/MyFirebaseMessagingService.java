package com.example.newraspisanie.service;

import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String PUSH_NOTIFICATION = "Пуш";

    public static final int NOTIFICATION_ID = 2042;
    private static final String MSG_TITLE = "msgTitle";
    private static final String MSG_BODY = "msgBody";
    private static final String ACTION = "action";
    private static final String POLL_ID = "poll_id";
    private static final String NEWS_ID = "id";
    private static final String NOVELTY_ID = "novelty_id";

    private static final String TYPE_POLL = "poll";
    private static final String TYPE_NEWS = "news";
    private static final String TYPE_NOVELTY = "novelty";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        sendNotification(remoteMessage);
    }

    private void sendNotification(RemoteMessage remoteMessage) {
        Intent actionIntent = null;
        Map<String, String> data = remoteMessage.getData();
        String type = data.get(ACTION);
        String msgTitle = data.get(MSG_TITLE);
        String msgBody = data.get(MSG_BODY);

//        int smallIcon = isWhiteIcon() ? R.drawable.ic_notification_poll_transparent : R.drawable.ic_notification_poll;
//
//        if (type != null) {
//            switch (type) {
//                case TYPE_POLL:
//                    smallIcon = isWhiteIcon() ? R.drawable.ic_notification_poll_transparent : R.drawable.ic_notification_poll;
//                    actionIntent = PollsActivity.getStartIntent(this, Long.parseLong(data.get(POLL_ID)));
//                    break;
//                case TYPE_NEWS:
//                    smallIcon = isWhiteIcon() ? R.drawable.ic_notification_news_transparent : R.drawable.ic_notification_news;
//                    actionIntent = NewsActivity.getStartIntent(this, Integer.valueOf((data.get(NEWS_ID))), data.get("title"), data.get("url"));
//                    break;
//                case TYPE_NOVELTY:
//                    smallIcon = isWhiteIcon() ? R.drawable.ic_notification_novelty_transparent : R.drawable.ic_notification_novelty;
//                    actionIntent = NoveltyActivity.getStartIntent(this, Integer.valueOf(data.get(NOVELTY_ID)));
//                    break;
//            }
//        }
//
//        if (actionIntent != null && Session.get().hasSession()) {
//            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, actionIntent,
//                    PendingIntent.FLAG_ONE_SHOT);
//
//            Bitmap largeIconBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launch);
//
//            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//                    .setSmallIcon(smallIcon)
//                    .setLargeIcon(largeIconBitmap)
//                    .setContentTitle(msgTitle)
//                    .setContentText(msgBody)
//                    .setAutoCancel(true)
//                    .setSound(defaultSoundUri)
//                    .setContentIntent(pendingIntent);
//
//            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
//        }
    }

    private boolean isWhiteIcon() {
        return android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    }
}
