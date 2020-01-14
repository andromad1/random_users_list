package ua.andromad.testassignmentaxon.loaders;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.loader.content.Loader;

import ua.andromad.testassignmentaxon.presenters.UsersListPresenter;

public class UsersListLoader extends Loader<UsersListPresenter> {
    private UsersListPresenter presenter;

    public UsersListLoader(@NonNull Context context, UsersListPresenter presenter) {
        super(context);
        this.presenter = presenter;
    }

    @Override
    protected void onStartLoading() {
        deliverResult(presenter);
    }
}
