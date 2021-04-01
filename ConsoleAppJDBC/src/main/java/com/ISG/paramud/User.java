package com.ISG.paramud;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 100L;
    private static int count = 100;
    final int id;
    private final String login;
    private final String password;
    static List<User> userList = new ArrayList<>();
    List<BookItem> phoneBook = new ArrayList<>();
    BookItem foundContact;
    
    public User(String login, String password) {
        ++count;
        this.login = login;
        this.password = password;
        this.id = count;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getPassword() {
        return password;
    }
    
    void findContact(User user, String searchingValue) {
        foundContact = user.phoneBook.stream()
                .filter(x -> x.getName().equals(searchingValue) ||
                        x.getPhone().equals(searchingValue) || x.getEmail().equals(searchingValue))
                .findFirst()
                .orElse(null);
        if (foundContact != null) {
            System.out.println(foundContact + "\n");
        } else {
            System.out.println("Not found" + "\n");
        }
    }
    
    void removeContact(User user, String searchingValue) {
        foundContact = user.phoneBook.stream()
                .filter(x -> x.getName().equals(searchingValue) ||
                        x.getPhone().equals(searchingValue) || x.getEmail().equals(searchingValue))
                .findFirst()
                .orElse(null);
        if (foundContact != null) {
            System.out.println(foundContact + "was deleted" + "\n");
            phoneBook.remove(foundContact);
        } else {
            System.out.println("Not found" + "\n");
        }
    }
    
    public static void addUser(User user) {
        userList.add(user);
    }
    
    public List<BookItem> getPhoneBook() {
        return phoneBook;
    }
    
    public void addBookItem(User user, BookItem bookItem) {
        List<BookItem> phoneBook = user.getPhoneBook();
        phoneBook.add(bookItem);
    }

    public static void saveUser() throws Exception {
        FileOutputStream fos = new FileOutputStream(
                "C:\\Java\\ConsoleAppJDBC\\src\\main\\java\\com\\ISG\\paramud\\listOfUsers.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userList);
        oos.close();
    }
    
    public static void loadUsers() throws Exception {
        FileInputStream fis = new FileInputStream(
                "C:\\Java\\ConsoleAppJDBC\\src\\main\\java\\com\\ISG\\paramud\\listOfUsers.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        userList = (ArrayList<User>) ois.readObject();
        ois.close();
    }
    public void loadPhoneBook(User user, String fileName) throws Exception {
        FileInputStream fis = new FileInputStream(
                "C:\\Java\\ConsoleAppJDBC\\src\\main\\java\\com\\ISG\\paramud\\" + fileName + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        user.phoneBook = (List<BookItem>) ois.readObject();
        ois.close();
    }
    
    public void savePhoneBook(User user, String fileName) throws Exception {
        FileOutputStream outputStream = new FileOutputStream(
                "C:\\Java\\ConsoleAppJDBC\\src\\main\\java\\com\\ISG\\paramud\\" + fileName + ".ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user.getPhoneBook());
        objectOutputStream.close();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, phoneBook, foundContact);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                login.equals(user.login) &&
                password.equals(user.password);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "phoneBook=" + this.phoneBook +
                '}';
    }
}
