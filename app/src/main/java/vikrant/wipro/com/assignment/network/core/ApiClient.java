package vikrant.wipro.com.assignment.network.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vikrant.wipro.com.assignment.R;
import vikrant.wipro.com.assignment.WiproAssignment;

/**
 * Created by Vikrant Alekar on 23-11-2018.
 */

public class ApiClient {
    private static final String BASE_URL = WiproAssignment.getContext().getResources().getString(R.string.api_base_url);
    private static Retrofit retrofit = null;
    private final static long TIMEOUT = 5;

    private ApiClient() {
    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGsonFactory()))
                    .client(getHttpClient())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getHttpClient() {
        return new OkHttpClient().newBuilder().readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS).build();
    }

    private static Gson getGsonFactory() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }
}
