package com.driver.model;

import com.driver.model.Connection;
import com.driver.model.Country;
import com.driver.model.ServiceProvider;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String originalIp;
    private String maskedIp;
    private boolean connected;

    @ManyToMany
    List<ServiceProvider> serviceProviders = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Connection> connectionList = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    Country country;

    public User() {
    }

    public User(int id, String username, String password, String originalIp, String maskedIp, boolean connected, List<ServiceProvider> serviceProviders, List<Connection> connectionList, Country country) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.originalIp = originalIp;
        this.maskedIp = maskedIp;
        this.connected = connected;
        this.serviceProviders = serviceProviders;
        this.connectionList = connectionList;
        this.country = country;
    }

    public User(String username, String password, String originalIp, Country country) {
        this.username = username;
        this.password = password;
        this.originalIp = originalIp;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginalIp() {
        return originalIp;
    }

    public void setOriginalIp(String originalIp) {
        this.originalIp = originalIp;
    }

    public String getMaskedIp() {
        return maskedIp;
    }

    public void setMaskedIp(String maskedIp) {
        this.maskedIp = maskedIp;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public List<ServiceProvider> getServiceProviders() {
        return serviceProviders;
    }

    public void setServiceProviders(List<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public Country getOriginalCountry() {
        return country;
    }

    public void setOriginalCountry(Country country) {
        this.country = country;
    }

}