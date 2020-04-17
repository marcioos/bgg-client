package com.github.bggclient;

import com.github.bggclient.fetch.domain.FetchItemOutput;
import com.github.bggclient.fetch.domain.UserCollection;
import com.github.bggclient.search.domain.SearchOutput;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.concurrent.TimeUnit;

public interface BggService {

    String BASE_URL = "http://www.boardgamegeek.com/xmlapi2/";

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(20L, TimeUnit.SECONDS)
            .readTimeout(10L, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build();

    BggService INSTANCE = new Builder().baseUrl(BASE_URL)
                                       .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                                       .client(client)
                                       .build()
                                       .create(BggService.class);

    @GET("search")
    Call<SearchOutput> search(@Query("query") String query, @Query("type") String types);

    @GET("thing")
    Call<FetchItemOutput> fetch(@Query("id") String ids, @Query("type") String types);

    @GET("collection")
    Call<UserCollection> fetchCollection(@Query("username") String ownerName, @Query("own") int own);
}
