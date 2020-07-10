package com.github.panarik.smartFeatures.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.panarik.smartFeatures.app.shop.R;
import com.github.panarik.smartFeatures.data.recyclerview.RecyclerViewAdapter;
import com.github.panarik.smartFeatures.data.recyclerview.RecyclerViewItem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerViewAdapter.RecyclerItemListener {

    private RecyclerView recyclerView; //переменная для связывания разметки с java кодом
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager; //управление расположением элементов recyclerView
    ArrayList<RecyclerViewItem> recyclerViewItems;

    private final String TAG = "onItemClick";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerViewItems = new ArrayList<>();
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.mobile_shop_shoping, "Mobile shopping", "Insert text, spinner, quantity, sopping card, send order on email"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.chest_open_gold, "Free Game", "эффекты alpha и немного математики"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.picture_effects_plash_smoke, "Picture effects", "alpha, rotate, scale, slide effects"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.list_view_list, "List View", "пример простого списка значений"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.playing_audio_band, "Play music", "sound playing, play pause buttons, seekBar"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.video_local_video, "Local video", "video from APK, control panel, volume listener"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.video_web_movie, "Movies online", "Text and pictures from API, RecycleView, search function,"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_satisfied_black_24dp, "Happy", "Life is fun"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_neutral_black_24dp, "Normal", "Life is life"));
        recyclerViewItems.add(new RecyclerViewItem(R.drawable.ic_sentiment_dissatisfied_black_24dp, "Sad", "Life is sad"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);     //для улучшения производительности задаем количество строк
        adapter = new RecyclerViewAdapter(recyclerViewItems,
                this //добавили listener
        );
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void goToChat(View view) {
        Intent goToChatActivity = new Intent(RecyclerViewActivity.this, SignInActivity.class);
        startActivity(goToChatActivity);
    }


    //метод для клика по recyclerview item
    @Override
    public void recycler_onItemClick(int position) {
        Log.d(TAG, "onNoteClick: clicked");

        //используем текущий ArrayList
        recyclerViewItems.get(position);

        switch (position){
            case 0:
                Intent someIntent = new Intent(this, SomeActivity.class);
                startActivity(someIntent);
                break;
            case 1:
                Intent some2Intent = new Intent(this, Some2Activity.class);
                startActivity(some2Intent);
            default:
                Log.d(TAG, "Nope");
        }

        //переход в активити по клику
        //Intent intent = new Intent(this, SomeActivity.class);
        //intent.putExtra("some_object", "something else");
        //startActivity(intent);
    }


}