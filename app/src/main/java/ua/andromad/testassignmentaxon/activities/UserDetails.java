package ua.andromad.testassignmentaxon.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ua.andromad.testassignmentaxon.R;
import ua.andromad.testassignmentaxon.response.User;

public class UserDetails extends AppCompatActivity implements View.OnClickListener {
    private final static SimpleDateFormat dobFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private final static SimpleDateFormat dobShowFormat = new SimpleDateFormat("yyyy-MM-dd");
    private EditText userPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView userImageView = findViewById(R.id.user_image_view);
        TextView userName = findViewById(R.id.textFullName);
        TextView userGender = findViewById(R.id.textGender);
        TextView userDofB = findViewById(R.id.textDofB);
        userPhone = findViewById(R.id.editPhone);
        EditText userEmail = findViewById(R.id.editEmail);
        EditText userAge = findViewById(R.id.editAge);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            User user = (User) data.getParcelable("user");

            Picasso.get().load(user.getPicture().getLarge()).into(userImageView);
            userName.setText(user.getUserName().getFirst() + " " + user.getUserName().getLast());
            userGender.setText(user.getGender());

            try {
                Date dateOfB = dobFormat.parse(user.getDob().getDate());
                userDofB.setText(dobShowFormat.format(dateOfB));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            userPhone.setText(user.getPhone());
            userEmail.setText(user.getEmail());
            userAge.setText(String.valueOf(user.getDob().getAge()));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCall:
                Uri uri = Uri.parse("tel:" + userPhone.getText().toString());
                Intent intent = new Intent(Intent.ACTION_CALL, uri);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Grant permission to call users!", Toast.LENGTH_LONG).show();
                    } else {
                        startActivity(intent);
                    }
                } else {
                    startActivity(intent);
                }

                break;
        }
    }
}
