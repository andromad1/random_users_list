package ua.andromad.testassignmentaxon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import ua.andromad.testassignmentaxon.R;
import ua.andromad.testassignmentaxon.response.User;

public class MainActivity extends AppCompatActivity implements RandomUserFragment.OnListFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onListFragmentInteraction(User user) {
        Intent intent = new Intent(MainActivity.this, UserDetails.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
