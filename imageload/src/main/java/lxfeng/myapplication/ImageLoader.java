package lxfeng.myapplication;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <类描述>
 * 作者： Administrator
 * 时间： 2016/3/3
 */
public class ImageLoader {

    private static ImageLoader INSTANCE;
    private ImageLoaderConfiguration mImageLoaderConfiguration;

    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private ImageLoader(){

    }

    public static ImageLoader getInstance(){
        if (INSTANCE == null){
            synchronized(ImageLoader.class){
                if (INSTANCE == null){
                    INSTANCE = new ImageLoader();
                }
            }
        }
        return INSTANCE;
    }

    public synchronized void init(ImageLoaderConfiguration imageLoaderConfiguration){
        mImageLoaderConfiguration = imageLoaderConfiguration;
        mExecutorService = Executors.newFixedThreadPool(imageLoaderConfiguration.threadPoolSize);
    }

    public void displayImage(final String url, final ImageView imageView){
        ImageCache imageCache = mImageLoaderConfiguration.imageCache;
        Bitmap bitmap =  imageCache.get(url);
        if (bitmap != null){
            imageView.setImageBitmap(bitmap);
            return;
        }
        imageView.setTag(url);
        mExecutorService.submit(new ImageDownLoaderTask(url,imageView, imageCache));
    }



}
