package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static User[] users = new User[0];

    public static void main(String[] args) {

        String input = "";

        while (!input.equals("exit")) {

            User user = getBasicUser();

            System.out.println("Want to fill in address now? ");
            String wantsAddress = scanner.nextLine();

            if (wantsAddress.equals("yes") || wantsAddress.equalsIgnoreCase("y")) {

                user.setAddress(getAddress());
            }

            System.out.println(user.toString());

            User[] userCopy = new User[users.length + 1];

            for (int i = 0; i < users.length; i++) {
                //max: 9        9
                userCopy[i] = users[i];
            }
//            userCopy = new User[]{};


            user.setUserId(userCopy.length);
            userCopy[userCopy.length - 1] = user;

//            userCopy.length = 1   <-->  userCopy[0]
//            userCopy.length = 10   <-->  userCopy[9]
//            userCopy.length = 11   <-->  userCopy[10]-->(our new user from console input)
//            userCopy.length = 20   <-->  userCopy[19]


            //1000   1001
            users = userCopy;
            //1001   1001

            System.out.println("Current users in the system");
            printUsers();

            System.out.println("Enter \"exit\" to quit");
            input = scanner.nextLine();
        }
    }

    private static void printUsers() {
        for (User user : users) {
            System.out.println("------------------------------------------------");
            System.out.println();

            System.out.println(String.format("User ID: %s", user.getUserId()));
            System.out.println(String.format("First name: %s", user.getFirstName()));
            System.out.println(String.format("Last name: %s", user.getLastName()));
            if (user.getAddress() == null) {
                System.out.println(String.format("Address: %s", "Not provided"));
            } else {
                System.out.println(String.format("City: %s", user.getAddress().getCity()));
                System.out.println(String.format("Street: %s", user.getAddress().getStreet()));
                System.out.println(String.format("House number: %s", user.getAddress().getHouseNumber()));
            }

            System.out.println();
            System.out.println("------------------------------------------------");

        }
    }

    private static Address getAddress() {
        System.out.println("City");
        String city = scanner.nextLine();


        System.out.println("Street");
        String street = scanner.nextLine();

        System.out.println("House number");
        String houseNumber = scanner.nextLine();

        Address address = new Address(city, street, houseNumber);
        return address;
    }

    private static User getBasicUser() {
        System.out.println("First name");
        String firstName = scanner.nextLine();

        System.out.println("Last name");
        String lastName = scanner.nextLine();

        return new User(firstName, lastName);
    }
}

class User {
    private Integer userId;
    private String firstName;
    private String lastName;
    private Address address;


    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address {
    private String city;
    private String street;
    private String houseNumber;

    private Address address;

    public Address(String city, String street, String houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}

