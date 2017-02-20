package com.epam.gittesting.data;

import java.math.BigInteger;
import java.util.Random;

public class ProfileData {

    private String name;
    private String bio;
    private String blog;
    private String company;

    private String nameGeneration() {
        Random random = new Random();
        return new BigInteger(130, random).toString(32);
    }

    public ProfileData(){
        name = nameGeneration();
        bio = "I don't really know, what to print there, so i'll just put it here. C'mon, it's just a simple test.";
        blog = "http//justsomesiteaddress.com";
        company = "EPAM Systems";
    }

    public String getName() {
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

}
