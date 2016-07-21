package ato.spordiklubi.lastemvpublic.app.network;

import java.util.concurrent.TimeUnit;

import ato.spordiklubi.lastemvpublic.Config;
import ato.spordiklubi.lastemvpublic.app.dto.Competitor;
import ato.spordiklubi.lastemvpublic.app.network.response.RegisterCompetitorResponse;
import ato.spordiklubi.lastemvpublic.app.util.CustomGson;
import ato.spordiklubi.lastemvpublic.app.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class LasteMVPublicApi {
    /**
     * Connect timeout value. In milliseconds.
     */
    private static final long TIMEOUT_CONNECT = 10 * 1000L;
    /**
     * Read timeout value. In milliseconds.
     */
    private static final long TIMEOUT_READ = 15 * 1000L;
    /**
     * Write timeout value. In milliseconds.
     */
    private static final long TIMEOUT_WRITE = 15 * 1000L;
    private static final Log log = Log.getInstance(LasteMVPublicApi.class);
    private static volatile LasteMVPublicApi instance;
    private final LasteMVPublicApiCalls apiCalls;

    public LasteMVPublicApi(final String baseUrl) {
        log.d("hello!");
        final HttpLoggingInterceptor interceptorLogging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                log.d(message);
            }
        });
        interceptorLogging.setLevel(Config.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT_WRITE, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT_READ, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptorLogging);
        final OkHttpClient client = okHttpBuilder.build();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(CustomGson.getInstance()))
                .build();
        apiCalls = retrofit.create(LasteMVPublicApiCalls.class);
    }

    public LasteMVPublicApiCalls getApiCalls() {
        return apiCalls;
    }

    public static LasteMVPublicApi getInstance(final String baseUrl) {
        if(instance == null) {
            synchronized (LasteMVPublicApi.class) {
                if(instance == null) {
                    createNewInstance(baseUrl);
                }
            }
        }
        return instance;
    }

    public static LasteMVPublicApi createNewInstance(String baseUrl) {
        synchronized (LasteMVPublicApi.class) {
            instance = new LasteMVPublicApi(baseUrl);
            return instance;
        }
    }

    public interface LasteMVPublicApiCalls {
        @Headers({
                "Content-Type: application/json"
        })
        @POST("competitors")
        Call<RegisterCompetitorResponse>registerCompetitor(@Body Competitor competitor);
    }
}
