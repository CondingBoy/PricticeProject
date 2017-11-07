package example.wangdachui.aboutrecyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

import example.wangdachui.aboutrecyclerview.R;
import example.wangdachui.aboutrecyclerview.adapter.ItemTouchHelperAdapter;
import example.wangdachui.aboutrecyclerview.adapter.SimpleTouchHelperCallback;

public class ItemTouchHelperActivity extends AppCompatActivity {
    public RecyclerView rvItemTouchHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_touch_helper);
        rvItemTouchHelper=(RecyclerView)findViewById(R.id.rv_touchHelper);
        ItemTouchHelperAdapter adapter = new ItemTouchHelperAdapter(this,generateData());
        rvItemTouchHelper.setAdapter(adapter);
        rvItemTouchHelper.setLayoutManager(new LinearLayoutManager(this));
        SimpleTouchHelperCallback callback = new SimpleTouchHelperCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rvItemTouchHelper);
    }

    private List<String> generateData(){
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
           temp.add("练习ItemTouchHelper的第"+i+"个item");
        }
        return temp;
    }

}
