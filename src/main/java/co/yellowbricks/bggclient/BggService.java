package co.yellowbricks.bggclient;

import retrofit.RestAdapter.Builder;
import retrofit.converter.SimpleXMLConverter;
import retrofit.http.GET;
import retrofit.http.Query;
import co.yellowbricks.bggclient.fetch.domain.FetchItemOutput;
import co.yellowbricks.bggclient.fetch.domain.UserCollection;
import co.yellowbricks.bggclient.search.domain.SearchOutput;

public interface BggService {

    public static final String BASE_URL = "http://www.boardgamegeek.com/xmlapi2";

    @GET("/search")
    public SearchOutput search(@Query("query") String query, @Query("type") String types);

    @GET("/thing")
    public FetchItemOutput fetch(@Query("id") String ids, @Query("type") String types);

    @GET("/collection")
    public UserCollection fetchCollection(@Query("username") String ownerName, @Query("own") int own);

    public static class SingletonHolder {

        private static final BggService INSTANCE;

        static {
            INSTANCE = new Builder().
                    setEndpoint(BASE_URL).
                    setConverter(new SimpleXMLConverter()).build().create(BggService.class);
        }

        public static BggService getInstance() {
            return INSTANCE;
        }
    }
}
