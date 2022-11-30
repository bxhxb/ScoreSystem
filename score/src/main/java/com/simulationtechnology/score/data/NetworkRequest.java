package com.simulationtechnology.score.data;

import com.simulationtechnology.score.vo.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface NetworkRequest {

    @GET("")
    @Headers("Accept: application/json")
    Call<String> getHttpsResults();

    @GET("api/v1/sys/jira/issue/{issueIdOrKey}")
    @Headers("Accept: application/json")
    Call<SearchResponse> searchSpecificTicket(@Path("issueIdOrKey") String ticketId);

}
