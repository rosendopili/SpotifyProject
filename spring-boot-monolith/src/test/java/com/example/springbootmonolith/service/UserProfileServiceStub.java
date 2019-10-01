package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.UserProfile;


public class UserProfileServiceStub implements UserProfileService {
    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("test@gmail.com");

        return userProfile;
    }

    @Override
    public UserProfile getUserProfile(String username) {
        return null;
    }
}
