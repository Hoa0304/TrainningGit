package com.ttchoa22ite.population.models;



import java.sql.Date;

public class Resident {


    private String sshk;
    private String cccd;
    private String name;
    private String sex;
    private String NOphone;
    private String address;
    private String job;
    private String nationality;
    private String domicile;
    private Date date;
    private Date upDate;

    public Resident(String sshk, String cccd, String name, String sex, String NOphone, String address, String job, String nationality, String domicile, Date date, Date upDate) {

        this.sshk = sshk;
        this.cccd = cccd;
        this.name = name;
        this.sex = sex;
        this.NOphone = NOphone;
        this.address = address;
        this.job = job;
        this.nationality = nationality;
        this.domicile = domicile;
        this.date = date;
        this.upDate = upDate;
    }

    public Resident() {
    }


    public String getSshk() {
        return sshk;
    }

    public void setSshk(String sshk) {
        this.sshk = sshk;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNOphone() {
        return NOphone;
    }

    public void setNOphone(String NOphone) {
        this.NOphone = NOphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }
}