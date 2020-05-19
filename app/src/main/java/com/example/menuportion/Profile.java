package com.example.menuportion;

public class Profile {
    private String name;
    private String email;
    private String profilePic;
    private boolean permissions;

    public Profile() {
    }

    public Profile(String name, String email, String profilePic, boolean permissions) {
        this.name = name;
        this.email = email;
        this.profilePic = profilePic;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePics(String profilePics) {
        this.profilePic = profilePic;
    }

    public boolean getPermissions() {
        return permissions;
    }

    public void setPermissions(boolean permissions) {
        this.permissions = permissions;
    }
}
