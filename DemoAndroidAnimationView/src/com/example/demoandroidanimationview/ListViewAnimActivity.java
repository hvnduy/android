package com.example.demoandroidanimationview;

import java.util.ArrayList;
import java.util.List;
 
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
 
public class ListViewAnimActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_anim);
 
        ListView lv = (ListView) findViewById(R.id.listView);
 
        List<ItemDetail> itemList = createItems(20);
 
        //Tải animation
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_anim);
 
        //Tạo dữ liệu cho listview bằng Adapter
        final ArrayAdapter<ItemDetail> aAdpt = new ArrayAdapter<ItemDetail>(this, android.R.layout.simple_list_item_1, itemList);
   
        //Đổ dữ liệu từ Adapter vào listview
        lv.setAdapter(aAdpt);
 
        //Thiết lập sự kiện cho listview
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, final int position, long id) {
                //Thiết lập lắng nghe từ sự kiện
                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
 
                    }
 
                    @Override
                    public void onAnimationRepeat(Animation animation) {
 
                    }
 
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ItemDetail item = aAdpt.getItem(position);
                        aAdpt.remove(item);
                    }
                });
                view.startAnimation(anim);
            }
        });
    }
 
    //Khởi tạo listview
    private List<ItemDetail> createItems(int size) {
        List<ItemDetail> result = new ArrayList<ItemDetail>();
        for (int i = 0; i < size; i++) {
            ItemDetail item = new ItemDetail(i, "Item " + i);
            result.add(item);
        }
        return result;
    }
}