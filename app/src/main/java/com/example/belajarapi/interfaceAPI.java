package com.example.belajarapi;

    import retrofit2.Call;
    import retrofit2.http.GET;

public interface interfaceAPI {

    String API_KEY = "http://api.musixmatch.com/ws/1.1/track.lyrics.get?";

    @GET("ws/1.1/track.lyrics.get?apikey="+API_KEY+"&page_size=10&page=1")
    Call<responseAPI> getMusicData();

}
