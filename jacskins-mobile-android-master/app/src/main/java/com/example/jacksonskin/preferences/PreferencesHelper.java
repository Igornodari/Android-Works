package com.example.jacksonskin.preferences;


public interface PreferencesHelper {

    boolean isUserLogged();

    void setUserLogged(boolean status);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);


}
