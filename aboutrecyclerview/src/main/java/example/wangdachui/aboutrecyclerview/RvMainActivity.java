package example.wangdachui.aboutrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.wangdachui.aboutrecyclerview.activity.ItemTouchHelperActivity;

public class RvMainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btItemTouchHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_main);
        btItemTouchHelper=(Button) findViewById(R.id.bt_item_touch_helper);
        btItemTouchHelper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      if(R.id.bt_item_touch_helper==v.getId()){
        startActivity(new Intent(this, ItemTouchHelperActivity.class));
      }
    }
}
