package com.example.users.Model;

import java.io.Serializable;

public class Users implements Serializable {
  private String website;

  private Address address;

  private String phone;

  private String name;

  private Company company;

  private Integer id;

  private String email;

  private String username;

  public String getWebsite() {
    return this.website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Company getCompany() {
    return this.company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public static class Address implements Serializable {
    private String zipcode;

    private Geo geo;

    private String suite;

    private String city;

    private String street;

    public String getZipcode() {
      return this.zipcode;
    }

    public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
    }

    public Geo getGeo() {
      return this.geo;
    }

    public void setGeo(Geo geo) {
      this.geo = geo;
    }

    public String getSuite() {
      return this.suite;
    }

    public void setSuite(String suite) {
      this.suite = suite;
    }

    public String getCity() {
      return this.city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getStreet() {
      return this.street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    public static class Geo implements Serializable {
      private String lng;

      private String lat;

      public String getLng() {
        return this.lng;
      }

      public void setLng(String lng) {
        this.lng = lng;
      }

      public String getLat() {
        return this.lat;
      }

      public void setLat(String lat) {
        this.lat = lat;
      }
    }
  }

  public static class Company implements Serializable {
    private String bs;

    private String catchPhrase;

    private String name;

    public String getBs() {
      return this.bs;
    }

    public void setBs(String bs) {
      this.bs = bs;
    }

    public String getCatchPhrase() {
      return this.catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
      this.catchPhrase = catchPhrase;
    }

    public String getName() {
      return this.name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
