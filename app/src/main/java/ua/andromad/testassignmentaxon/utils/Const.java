package ua.andromad.testassignmentaxon.utils;

import java.text.SimpleDateFormat;

public class Const {
    public static final SimpleDateFormat dobFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    public static final SimpleDateFormat dobShowFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static final String LOG_TAG = "Axon_Test_LOG";
    public static final String EXTRA_user = "user";

    public static final int COMMAND_ALL_LIST_USERS = 1;
    public static final int COMMAND_UPDATE_LIST_USERS = 2;
    public static final int COMMAND_SHOW_TOAST = 3;
}
