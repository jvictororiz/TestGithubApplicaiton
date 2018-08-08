package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private static final long TIMEOUT_SECOUNDS = 20;


    public static Retrofit getRetrofit() {
        return buildRetrofit();
    }

    private static Retrofit buildRetrofit() {
        String baseUrl = "https://api.github.com/";
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client;
        client = new OkHttpClient.Builder()
                //.addInterceptor(buildInterceptor())
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private static Interceptor buildInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                Request request = buildRequest(original);
                return chain.proceed(request);
            }
        };
    }

    private static Request buildRequest(Request original) {
        return original.newBuilder()
                .header("Content-Type", "application/json")
                .method(original.method(), original.body()).build();
    }
}