package ato.spordiklubi.lastemvpublic.app.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.WeakHashMap;

import ato.spordiklubi.lastemvpublic.Config;
import ato.spordiklubi.lastemvpublic.app.ServiceListener;
import ato.spordiklubi.lastemvpublic.app.util.Log;

public class LasteMvNetworkService {
    private static volatile LasteMvNetworkService instance;
    private final Context appContext;
    private static Log log = Log.getInstance(LasteMvNetworkService.class);
    private LasteMVPublicApi.LasteMVPublicApiCalls LasteMVAPI;
    private final WeakHashMap<String, ServiceListener> listeners = new WeakHashMap<>(); // is it ok to set it weak?


    public static LasteMvNetworkService getInstance(final Context appContext) {
        if (instance == null) {
            synchronized (LasteMvNetworkService.class) {
                if (instance == null) {
                    instance = new LasteMvNetworkService(appContext);
                }
            }
        }
        return instance;
    }

    private LasteMvNetworkService(final Context ctx) {
        if (ctx == null) {
            throw new IllegalArgumentException("Context can't be null!");
        }
        this.appContext = ctx.getApplicationContext();
        this.LasteMVAPI = LasteMVPublicApi.createNewInstance(Config.BASE_URL).getApiCalls();
    }

    public void setListener(final String tag, @Nullable final ServiceListener listener) {
        log.d("setListener: " + tag + ", listener: " + listener);
        if (TextUtils.isEmpty(tag)) {
            return;
        }
        synchronized (listeners) {
            listeners.put(tag, listener);
        }
    }

    private <T extends ServiceListener> T getListener(final String tag, final boolean forgetListener, @NonNull final Class<T> type) {
        log.d("getListener: " + tag + ", forgetListener: " + forgetListener);
        if (TextUtils.isEmpty(tag) || type == null) {
            return null;
        }
        synchronized (listeners) {
            if (listeners.get(tag) != null && type.isInstance(listeners.get(tag))) {
                //noinspection unchecked
                return (T) (forgetListener ? listeners.remove(tag) : listeners.get(tag));
            }
        }
        return null;
    }

    public void removeListener(final String tag) {
        if (TextUtils.isEmpty(tag)) {
            return;
        }
        synchronized (listeners) {
            listeners.remove(tag);
        }
    }
}

