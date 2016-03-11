package lxfeng.myapplication;

import android.graphics.Bitmap;

/**
 * <类描述>
 * 作者： Administrator
 * 时间： 2016/3/3
 */
public interface ImageCache {
    public void put(String url, Bitmap bitmap);

    public Bitmap get(String url);

    public void remove(String url);

    public void clear();
}
