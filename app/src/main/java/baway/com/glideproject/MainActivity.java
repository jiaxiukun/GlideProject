package baway.com.glideproject;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> list = new ArrayList<>();
    private ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getData();
        mList.setAdapter(new MyAdpter(list,this));
    }
    private void initView() {
        mList = (ListView) findViewById(R.id.listview);
    }

    private ArrayList getData() {
        User user=new User();
        user.url="http://pic11.nipic.com/20101214/213291_155243023914_2.jpg";
        list.add(user);
        User user1=new User();
        user1.photo=R.mipmap.ic_launcher;
        list.add(user1);
        User user2=new User();
        user2.url= Environment.getExternalStorageDirectory().getPath()+"/storage/emulated/O/DCIM/Camera/IMG_20170706_075057.jpg";
        list.add(user2);
        return list;
    }

}
