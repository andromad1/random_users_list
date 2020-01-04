package ua.andromad.testassignmentaxon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.andromad.testassignmentaxon.R;
import ua.andromad.testassignmentaxon.response.Users;
import ua.andromad.testassignmentaxon.services.RetrofitNetworkService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int pageNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        loadUsers();
    }

    private void loadUsers() {
        RetrofitNetworkService.getInstance()
                .getJSONApi()
                .getUsers(pageNum, 20, "abc")
                .enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if (response.isSuccessful()) {
                            Users users = response.body();
                            System.out.println(users);
                        } else {
                            System.out.println("Error occurred while getting responce: "+response.message());

                            if (response.errorBody() != null)
                                System.out.println(response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        System.out.println("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });

        pageNum++;
    }

    @Override
    public void onClick(View v) {
        loadUsers();
    }
}
