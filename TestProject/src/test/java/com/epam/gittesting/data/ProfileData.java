package com.epam.gittesting.data;

import java.math.BigInteger;
import java.util.Random;

public class ProfileData {

    private String name = "";
    private String bio = "";
    private String blog = "";
    private String company = "";

    private static String nameGeneration() {
        Random random = new Random();
        return new BigInteger(130, random).toString(32);
    }

    public String getName() {
        name = name.equals("") ? nameGeneration() : name;
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getBlog() {
        return blog;
    }

    public String getCompany() {
        return company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
