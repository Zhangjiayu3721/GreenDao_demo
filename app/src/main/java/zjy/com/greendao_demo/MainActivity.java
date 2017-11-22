package zjy.com.greendao_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.koma.greendao.gen.UserDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.add)
    Button add;
    @BindView(R.id.del)
    Button del;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.query)
    Button query;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        userDao = MyApplication.getInstances().getDaoSession().getUserDao();

    }

    @OnClick({R.id.add, R.id.del, R.id.update, R.id.query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                User user = new User((long)2,"zhangjiayu");
                userDao.insert(user);
                break;
            case R.id.del:
                userDao.deleteByKey((long)2);
                break;
            case R.id.update:
                User user1 = new User((long)2,"zjy");
                userDao.update(user1);
                break;
            case R.id.query:
                List<User> users = userDao.loadAll();
                String username = "";
                for (int i=0;i<users.size();i++){
                    username+=users.get(i).getName();
                }
                Toast.makeText(MainActivity.this,username,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
