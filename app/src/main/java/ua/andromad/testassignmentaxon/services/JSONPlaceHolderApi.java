package ua.andromad.testassignmentaxon.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.andromad.testassignmentaxon.response.Users;

public interface JSONPlaceHolderApi {
    @GET("?noinfo&inc=name,gender,email,dob,phone,picture")
    Call<Users> getUsers(@Query("page") int pageNumber,
                         @Query("results") int quantity,
                         @Query("seed") String seed);
}
