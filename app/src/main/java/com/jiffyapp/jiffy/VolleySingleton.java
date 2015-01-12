package com.jiffyapp.jiffy;

import android.app.ActivityManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Ehis on 1/11/15.
 * Volley Singleton for Application Request Queues
 *
 */


public class VolleySingleton {

    /** Internal instance variable */
    private static VolleySingleton sInstance;

    /** The request queue */
    private RequestQueue mRequestQueue;

    /** The image loader */
    private ImageLoader mImageLoader;

    /** Image cache implementation */
    private ImageLoader.ImageCache mImageCache;


    private VolleySingleton(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        int memClass = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
                .getMemoryClass();
        // Use 1/8th of the available memory for this memory cache.
        int cacheSize = 1024 * 1024 * memClass / 8;
        mImageCache = new LruBitmapCache(cacheSize);
        mImageLoader = new ImageLoader(mRequestQueue, mImageCache);
    }

    /**
     * Singleton
     */
    public static synchronized VolleySingleton getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new VolleySingleton(context);
        }
        else {

            return sInstance;
        }

        return sInstance;

    }

    public void addToRequestQueue(Request request) {
        mRequestQueue.add(request);
    }

    public ImageLoader getImageLoader() {
        if (sInstance == null) {
            throw new IllegalStateException("Singleton not initialized");
        }
        return mImageLoader;
    }
}
