package com.atomath.finalmedie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private static final String TITLE = "title";
    private static final String DESC = "description";
    private static final String IMG_LINK = "image_link";
    private static final String IMG_YOUTUBE = "youtube_image";
    private static final String YOUTUBE_ID = "youtubeID";
    private String title;
    private String description;
    private String image_link;
    private String youtube_image;
    private String youtubeID;
    private TextView txt_title;
    private TextView txt_desc;
    private ImageView img_link;
    private ImageView img_youtube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        readInboundIntent();
        bindWidget();
        setPage();

    }

    private void readInboundIntent() {
         title = getIntent().getStringExtra(TITLE);
         description = getIntent().getStringExtra(DESC);
         image_link = getIntent().getStringExtra(IMG_LINK);
         youtube_image = getIntent().getStringExtra(IMG_YOUTUBE);
         youtubeID = getIntent().getStringExtra(YOUTUBE_ID);
        Toast.makeText(DetailActivity.this, "ID : "+youtubeID, Toast.LENGTH_SHORT).show();

    }

    private void bindWidget() {
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_desc = (TextView) findViewById(R.id.txt_desc);
        img_link = (ImageView) findViewById(R.id.img_link);
        img_youtube = (ImageView) findViewById(R.id.img_youtube);

    }
    private void setPage() {
        txt_title.setText(title);
        txt_desc.setText(description);
        Glide.with(getApplicationContext()).load(image_link).into(img_link);
        Glide.with(getApplicationContext()).load(youtube_image).into(img_youtube);

    }
}
