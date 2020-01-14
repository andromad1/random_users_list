package ua.andromad.testassignmentaxon.utils;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import ua.andromad.testassignmentaxon.models.ModelInteractionListener;
import ua.andromad.testassignmentaxon.response.Users;
import ua.andromad.testassignmentaxon.services.RetrofitNetworkService;

import static ua.andromad.testassignmentaxon.utils.Const.LOG_TAG;

public class UtilNetwork {
    public static void loadUsers(ModelInteractionListener listener, int pageNum) {
        RetrofitNetworkService.getInstance()
                .getJSONApi()
                .getUsers(pageNum, 20, "abc")
                .enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if (response.isSuccessful()) {
                            listener.onUsersReceived(response.body(), true, null);
                        } else {
                            listener.onUsersReceived(null, false, "Error occurred while getting responce: "+response.message());

                            if (response.errorBody() != null)
                                Log.e(LOG_TAG, response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        listener.onUsersReceived(null, false, "Error occurred while getting request: "+t.getLocalizedMessage());
                        t.printStackTrace();
                    }
                });
    }
}
