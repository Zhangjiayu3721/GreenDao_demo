package zjy.com.greendao_demo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.koma.greendao.gen.DaoMaster;
import com.koma.greendao.gen.DaoSession;

/**
 * Created by ZhangJiaYu on 2017/11/15.
 */

public class MyApplication extends Application{

    public static MyApplication instances;
    DaoMaster.DevOpenHelper helper;
    SQLiteDatabase db;
    DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
    }

    public static MyApplication getInstances() {
        return instances;
    }

    private void setDatabase() {
        helper = new DaoMaster.DevOpenHelper(this,"demo_1115",null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
