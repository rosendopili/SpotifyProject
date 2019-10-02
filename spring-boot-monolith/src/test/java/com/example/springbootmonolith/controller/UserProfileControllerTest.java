package com.example.springbootmonolith.controller;

import com.example.springbootmonolith.models.UserProfile;
import com.example.springbootmonolith.UserController.UserProfileController;
import com.example.springbootmonolith.service.UserProfileServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserProfileControllerTest {

    //testing for UserProfileController methods
    private UserProfileController userProfileController;

    @Before
    public void initUserProfileController(){
        userProfileController = new UserProfileController();
        userProfileController.setUserProfileService(new UserProfileServiceStub());
    }

    @Test
    public void createUserProfile_SavesUserProfile_Success() throws Exception {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("test@gmail.com");

        UserProfile newProfile = userProfileController.createUserProfile("TestUser", userProfile);

        Assert.assertNotNull(newProfile);
        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());
    }

//    @Test
//    public void getUserProfile_RetrievesProfileByUsername_Success(){
//        UserProfile userProfile = new UserProfile();
//        userProfile.setUser();
//        UserProfile newProfile = userProfileController.createUserProfile("TestUser", userProfile);
//    }
}
