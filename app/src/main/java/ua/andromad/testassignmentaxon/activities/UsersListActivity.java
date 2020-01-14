package ua.andromad.testassignmentaxon.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import ua.andromad.testassignmentaxon.R;
import ua.andromad.testassignmentaxon.adapters.RandomUserRecyclerViewAdapter;
import ua.andromad.testassignmentaxon.loaders.UsersListLoader;
import ua.andromad.testassignmentaxon.models.UsersModel;
import ua.andromad.testassignmentaxon.presenters.UsersListPresenter;
import ua.andromad.testassignmentaxon.response.User;

import static ua.andromad.testassignmentaxon.utils.Const.COMMAND_ALL_LIST_USERS;
import static ua.andromad.testassignmentaxon.utils.Const.COMMAND_SHOW_TOAST;
import static ua.andromad.testassignmentaxon.utils.Const.COMMAND_UPDATE_LIST_USERS;
import static ua.andromad.testassignmentaxon.utils.Const.EXTRA_user;

public class UsersListActivity extends AppCompatActivity implements ListFragmentInteractionListener,
        LoaderManager.LoaderCallbacks<UsersListPresenter> {

    private int mColumnCount = 1;
    private RandomUserRecyclerViewAdapter mAdapter;
    private RecyclerView recyclerView;
    private UsersListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.list);;

        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, mColumnCount));
        }

        mAdapter = new RandomUserRecyclerViewAdapter(this);
        recyclerView.setAdapter(mAdapter);

        LoaderManager.getInstance(this).initLoader(1, null, this);
    }

    @Override
    public void onPause() {
        presenter.detachView();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @NonNull
    @Override
    public Loader<UsersListPresenter> onCreateLoader(int id, @Nullable Bundle args) {
        return new UsersListLoader(this, new UsersListPresenter());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<UsersListPresenter> loader, UsersListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onLoaderReset(@NonNull Loader<UsersListPresenter> loader) {
    }

    @Override
    public void updateUI(UsersModel usersModel) {
        switch (usersModel.getCommand()) {
            case COMMAND_ALL_LIST_USERS:
                mAdapter.setItems(usersModel.getUsers().getLstUsers());
                break;

            case COMMAND_UPDATE_LIST_USERS:
                mAdapter.setItems(usersModel.getLstNewUsers());
                break;

            case COMMAND_SHOW_TOAST:
                Toast.makeText(this, usersModel.getMessage(), Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public void onUserSelected(User user) {
        Intent intent = new Intent(this, UserDetailsActivity.class);
        intent.putExtra(EXTRA_user, user);
        startActivity(intent);
    }

    @Override
    public void onEndOfListReached() {
        Toast.makeText(this, "Loading data...", Toast.LENGTH_SHORT).show();
        presenter.getNewUsers();
    }
}
