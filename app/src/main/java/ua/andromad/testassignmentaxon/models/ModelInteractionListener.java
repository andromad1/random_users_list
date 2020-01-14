package ua.andromad.testassignmentaxon.models;

import ua.andromad.testassignmentaxon.response.Users;

public interface ModelInteractionListener {
    void onUsersReceived(Users lstUsers, boolean isSuccess, String msg);
}
