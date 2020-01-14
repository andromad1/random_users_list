package ua.andromad.testassignmentaxon.models;

import java.util.List;

import ua.andromad.testassignmentaxon.presenters.PresenterInteractionListener;
import ua.andromad.testassignmentaxon.response.User;
import ua.andromad.testassignmentaxon.response.Users;
import ua.andromad.testassignmentaxon.utils.UtilNetwork;

import static ua.andromad.testassignmentaxon.utils.Const.COMMAND_ALL_LIST_USERS;
import static ua.andromad.testassignmentaxon.utils.Const.COMMAND_SHOW_TOAST;
import static ua.andromad.testassignmentaxon.utils.Const.COMMAND_UPDATE_LIST_USERS;

public class UsersModel implements ModelInteractionListener {
    private int command = COMMAND_ALL_LIST_USERS;
    private String message = "";

    private int pageNum = 1;
    private Users users = new Users();
    private List<User> lstNewUsers;

    private PresenterInteractionListener listener;

    public UsersModel(PresenterInteractionListener listener) {
        this.listener = listener;
        getNewPageUsers();
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public String getMessage() {
        return message;
    }

    public Users getUsers() {
        return users;
    }

    public List<User> getLstNewUsers() {
        return lstNewUsers;
    }

    public void getNewPageUsers() {
        UtilNetwork.loadUsers(this, pageNum);
    }

    @Override
    public void onUsersReceived(Users usersPage, boolean isSuccess, String msg) {
        if (isSuccess) {
            lstNewUsers = usersPage.getLstUsers();
            users.getLstUsers().addAll(usersPage.getLstUsers());
            pageNum++;
            command = COMMAND_UPDATE_LIST_USERS;
            message = "";
        } else {
            message = msg;
            command = COMMAND_SHOW_TOAST;
        }

        listener.onChangeModel();
    }
}
