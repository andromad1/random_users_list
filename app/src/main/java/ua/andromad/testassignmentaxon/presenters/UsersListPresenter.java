package ua.andromad.testassignmentaxon.presenters;

import ua.andromad.testassignmentaxon.activities.ListFragmentInteractionListener;
import ua.andromad.testassignmentaxon.models.UsersModel;

import static ua.andromad.testassignmentaxon.utils.Const.COMMAND_ALL_LIST_USERS;

public class UsersListPresenter implements PresenterInteractionListener {
    private ListFragmentInteractionListener viewInterface;
    private UsersModel usersModel;

    public UsersListPresenter() {
        usersModel = new UsersModel(this);
    }

    public void attachView(ListFragmentInteractionListener viewInterface) {
        this.viewInterface = viewInterface;
        usersModel.setCommand(COMMAND_ALL_LIST_USERS);
        viewInterface.updateUI(usersModel);
    }

    public void detachView() {
        this.viewInterface = null;
    }

    public void getNewUsers() {
        usersModel.getNewPageUsers();
    }

    @Override
    public void onChangeModel() {
        viewInterface.updateUI(usersModel);
    }
}
