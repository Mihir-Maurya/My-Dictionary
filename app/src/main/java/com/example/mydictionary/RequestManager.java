package com.example.mydictionary;

import android.content.Context;
import android.widget.Toast;

import com.example.mydictionary.Models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {
Context context;
private static  Retrofit retrofit;
public static String BASE_URL = "https://api.dictionaryapi.dev/api/v2/";
public static Retrofit getRetrofit(){
    if(retrofit==null){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
    return retrofit;
}

    public RequestManager(Context context) {
        this.context = context;
    }
    public void getWordMeaning(onFetchDataListner listner,String word) {
        CallDictionary callDictionary = getRetrofit().create(CallDictionary.class);
        Call<List<ApiResponse>> call = callDictionary.callMeanings(word);
      //getting response
      try{
          call.enqueue(new Callback<List<ApiResponse>>() {
              @Override
              public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
                  if (!response.isSuccessful()) {
                      Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                      return;
                  }
                  listner.onFetchData(response.body().get(0),response.message());
              }
              @Override
              public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                    listner.onError("Request failed");
              }
          });
      }
      catch (Exception e){
          e.printStackTrace();
          Toast.makeText(context,"An Error Occured", Toast.LENGTH_LONG).show();
      }
}
    public interface CallDictionary{
    @GET("entries/en/{word}")
        Call<List<ApiResponse>> callMeanings(
                @Path("word") String word
    );
    }
}
