package lxfeng.myapplication;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * <类描述>
 * 作者： Administrator
 * 时间： 2016/3/3
 */
public class MemoryCache implements ImageCache{

    private LruCache<String,Bitmap> mMemoryCache;

    public MemoryCache(){
       init();
    }

    private void init(){
        final int maxSize = (int)(Runtime.getRuntime().maxMemory())/1024;
        final int cacheSize = maxSize / 4;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url,bitmap);
    }

    @Override
    public Bitmap get(String url) {
        return mMemoryCache.get(url);
    }

    @Override
    public void remove(String url) {
        mMemoryCache.remove(url);
    }

    @Override
    public void clear() {
        mMemoryCache.evictAll();
    }
}
