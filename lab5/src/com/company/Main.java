package com.company;

import java.io.*;
import java.util.ArrayList;


public class Main {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Request> bookRequests = new ArrayList<Request>();
    public static ArrayList<Request> humanRequests = new ArrayList<Request>();

    public static void main(String[] args) {
        load();
        new LogInForm();
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static User findUser(String login, String password) {
        for (User user : users) {
            if (user.enter(login, password)) {
                return user;
            }
        }
        return null;
    }

    public static void save() {
        try (
                FileOutputStream usersFile = new FileOutputStream("users.txt", false);
                ObjectOutputStream oosUser = new ObjectOutputStream(usersFile)) {
            oosUser.writeObject(users);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try (
                FileOutputStream workersRequestsFile = new FileOutputStream("book_requests.txt", false);
                ObjectOutputStream oosWorkerRequest = new ObjectOutputStream(workersRequestsFile)) {
            oosWorkerRequest.writeObject(bookRequests);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        try (
                FileOutputStream employeeRequestsFile = new FileOutputStream("human_requests.txt", false);
                ObjectOutputStream oosEmployeeRequest = new ObjectOutputStream(employeeRequestsFile)) {
            oosEmployeeRequest.writeObject(humanRequests);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void load() {
        try (ObjectInputStream oisUsers = new ObjectInputStream(new FileInputStream("users.txt"))) {
            users = (ArrayList<User>) oisUsers.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try (ObjectInputStream oisWorkerRequests = new ObjectInputStream(new FileInputStream("book_requests.txt"))) {
            bookRequests = (ArrayList<Request>) oisWorkerRequests.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try (
                FileOutputStream employeeRequestsFile = new FileOutputStream("human_requests.txt", false);
                ObjectOutputStream oosEmployeeRequest = new ObjectOutputStream(employeeRequestsFile)) {
            oosEmployeeRequest.writeObject(humanRequests);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public static void clearEmployerRequests(Client employee) {
        for (int i = bookRequests.size()-1; i >= 0; i--) {
            if (bookRequests.get(i).getRequester().getLogin().equals(employee.getLogin())) {
                bookRequests.remove(bookRequests.get(i));
            }
        }
    }

    public static String processRequests() {
        StringBuilder result = new StringBuilder();
        String ent = ProcessForm.enter();
        for (Request humanRequest :humanRequests) {
            for (int i = bookRequests.size()-1; i >= 0; i--) {
                if (
                        bookRequests.get(i).getSurname() == ent || ent == humanRequest.getSurname()

                )
                {
                    result.append(bookRequests.get(i).getRequester().takeResult(humanRequest.getNumber())).append("\n");
                    clearEmployerRequests(bookRequests.get(i).getRequester());
                    break;
                }
            }
        }
        for (Request bookRequest : bookRequests) {
            result.append(bookRequest.getRequester().getName()).append(", по вашему запросу ничего не найдено\n");
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
