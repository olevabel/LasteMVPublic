package ato.spordiklubi.lastemvpublic.app.model;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import ato.spordiklubi.lastemvpublic.app.dto.Competitor;
import ato.spordiklubi.lastemvpublic.app.network.LasteMvNetworkService;
import ato.spordiklubi.lastemvpublic.app.util.Log;

public class Model {
    private static volatile Model instance;
    private final Context appContext;
    private final LasteMvNetworkService lasteMvNetworkService;
    private static Log log = Log.getInstance(Model.class);
    private final Bus bus;

    public Model(final Context context) {
        this.appContext = context != null ? context.getApplicationContext() : null;
        bus = new Bus(ThreadEnforcer.MAIN);
        bus.register(this);
    }

    public static Model getInstance(final Fragment fragment) {
        return getInstance(fragment.getActivity());
    }

    public static Model getInstance(final Context context) {
        if(instance == null) {
            synchronized (Model.class) {
                if(instance == null) {
                    instance = new Model(context);
                }
            }
        }
        return instance;
    }

    public static void subscribe(Fragment fragment) {
        Model.getInstance(fragment).subscribe((Object) fragment);
    }

    public void subscribe(final Object o) {
        if (o == null) {
            return;
        }
        try {
            bus.register(o);
        } catch (Exception e) {
            log.e("subscribe", e);
        }
    }

    public static void unsubscribe(Fragment fragment) {
        Model.getInstance(fragment).unsubscribe((Object) fragment);
    }

    public void unsubscribe(final Object o) {
        if (o == null) {
            return;
        }
        try {
            bus.unregister(o);
        } catch (Exception e) {
            log.e("unsubscribe", e);
        }
    }

    public void cancelCallbackFor(final String tag) {
        // TODO: Should we also support swapping a UI listener to a Notification based listener
        if (lasteMvNetworkService != null) {
            // Just clear the listener for now!
            lasteMvNetworkService.removeListener(tag);
            log.d("cancelCallbackFor called for " + tag);
        }
    }
    public void registerCompetitor(final String tag, final Competitor competitor) {

    }

}
