package com.projects.jobplatform.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projects.jobplatform.modles.User;

public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;

    private User user;


    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String accessToken, User user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
