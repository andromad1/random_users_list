package ua.andromad.testassignmentaxon.activities;

import ua.andromad.testassignmentaxon.models.UsersModel;
import ua.andromad.testassignmentaxon.response.User;

public interface ListFragmentInteractionListener {
    void updateUI(UsersModel usersModel);
    void onUserSelected(User user);
    void onEndOfListReached();
}
