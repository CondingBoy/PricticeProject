package example.wangdachui.studyproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.wangdachui.aboutrecyclerview.RvMainActivity;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_rv)
    Button btRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.bt_rv)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_rv:
                startActivity(new Intent(this, RvMainActivity.class));
                break;
                default:
        }
    }

}
