package lxfeng.csdn;

import android.app.Application;

import lxfeng.myapplication.ImageLoader;
import lxfeng.myapplication.ImageLoaderConfiguration;
import lxfeng.myapplication.MemoryCache;

/**
 * <类描述>
 * 作者： Administrator
 * 时间： 2016/3/3
 */
public class CSDNApplication extends Application {

    private static CSDNApplication INSTANCE;

    public static CSDNApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder()
                .threadPoolSize(3)
                .setImageCache(new MemoryCache())
                .create();
        ImageLoader.getInstance().init(configuration);
    }
}
