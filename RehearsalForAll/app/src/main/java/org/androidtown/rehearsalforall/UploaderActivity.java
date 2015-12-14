package org.androidtown.rehearsalforall;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class UploaderActivity extends AppCompatActivity {

    private String selectedVideoPath;
    private Bitmap thumbnail;
    private VideoView videoView;
    private MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        selectedVideoPath = getRealPathFromURI(this, Uri.parse(getIntent().getStringExtra("VIDEO_URI")));
        setContentView(R.layout.activity_uploader);

        videoView = (VideoView) findViewById(R.id.videoView);
        thumbnail = ThumbnailUtils.createVideoThumbnail(selectedVideoPath,
                MediaStore.Images.Thumbnails.MINI_KIND);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(thumbnail);
        //videoView.setBackground(bitmapDrawable);

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

        videoView.setVideoPath(selectedVideoPath);
        videoView.requestFocus();
    }

    private String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;

        try {
            String[] projection = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query(contentUri, projection, null, null, null);
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(columnIndex);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

}
