package lxfeng.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <类描述>
 * 作者： Administrator
 * 时间： 2016/3/3
 */
public class ImageDownLoaderTask implements Runnable {

    private String url;
    private ImageView imageView;
    private ImageCache mImageCache;

    public ImageDownLoaderTask(String url, ImageView imageView,ImageCache imageCache){
        this.url = url;
        this.imageView = imageView;
        this.mImageCache = imageCache;
    }

    @Override
    public void run() {
        Bitmap bitmap = downloadImage(url);
        if (bitmap == null) return;
        if (imageView.getTag().equals(url)) {
            imageView.setImageBitmap(bitmap);
        }
        mImageCache.put(url,bitmap);
    }

    private Bitmap downloadImage(String imageUrl){
        Bitmap bitmap = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(imageUrl);
            conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                conn.disconnect();
            }
        }
        return bitmap;
    }
}
