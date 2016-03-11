package lxfeng.myapplication;

/**
 * <类描述>
 * 作者： Administrator
 * 时间： 2016/3/4
 */
public final class ImageLoaderConfiguration {

    final ImageCache imageCache;
    final int threadPoolSize;

    private ImageLoaderConfiguration(ImageLoaderConfiguration.Builder builder){
        this.imageCache = builder.imageCache;
        this.threadPoolSize = builder.threadPoolSize;
    }

    public static class Builder{
        private ImageCache imageCache;
        private int threadPoolSize;

        public Builder(){
            threadPoolSize = Runtime.getRuntime().availableProcessors() + 1;
            imageCache = new MemoryCache();
        }

        public ImageLoaderConfiguration.Builder threadPoolSize(int threadPoolSize ){
            this.threadPoolSize = threadPoolSize;
            return this;
        }

        public ImageLoaderConfiguration.Builder setImageCache(ImageCache imageCache){
            this.imageCache = imageCache;
            return this;
        }

        public ImageLoaderConfiguration create(){
           return new ImageLoaderConfiguration(this);
        }
    }

}
