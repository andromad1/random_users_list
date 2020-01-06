package ua.andromad.testassignmentaxon.utils;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import ua.andromad.testassignmentaxon.adapters.RandomUserRecyclerViewAdapter;
import ua.andromad.testassignmentaxon.response.Users;
import ua.andromad.testassignmentaxon.services.RetrofitNetworkService;

public class UtilNetwork {
    public static void loadUsers(RandomUserRecyclerViewAdapter adapter, Context context, int pageNum) {
        Toast.makeText(context, "Loading data...", Toast.LENGTH_SHORT).show();

        RetrofitNetworkService.getInstance()
                .getJSONApi()
                .getUsers(pageNum, 20, "abc")
                .enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if (response.isSuccessful()) {
                            adapter.setItems(response.body().getLstUsers());
                        } else {
                            Toast.makeText(context, "Error occurred while getting responce: "+response.message(),
                                    Toast.LENGTH_LONG).show();

                            if (response.errorBody() != null)
                                System.out.println(response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        Toast.makeText(context, "Error occurred while getting request!",
                                Toast.LENGTH_LONG).show();
                        t.printStackTrace();
                    }
                });
    }
}
