package com.ISG.paramud;

import java.io.*;

public class Main {
    
    
    public static void main(String[] args) {
        User workingUser = null;
        String answer;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("To log in type \'login\' or sign up type \'signup\', You can always type \'exit\' to exit");
        try {
            User.loadUsers();
            do {
                String newLogin = "";
                String oldPassword;
                String newPassword;
                int tryLog = 3;
                answer = buf.readLine();
                if (answer.trim().equals("login")) {
                    System.out.println("You need to log in");
                    do {
                        System.out.println("Enter your login");
                        answer = buf.readLine();
                        if (answer.trim().equals("exit")) break;
                        if (!answer.trim().equals("")) {
                            newLogin = answer.trim();
                            System.out.println("Enter your password");
                        }
                        answer = buf.readLine();
                        if (answer.trim().equals("exit")) break;
                        if (!answer.equals("")) {
                            oldPassword = answer.trim();
                            String finalOldPassword = oldPassword;
                            String finalNewLogin = newLogin;
                            if (User.userList.stream().anyMatch(x -> x.getLogin().equals(finalNewLogin) &
                                    x.getPassword().equals(finalOldPassword))) {
                                workingUser = User.userList.stream()
                                        .filter(x -> x.getLogin().equals(finalNewLogin) &
                                                x.getPassword().equals(finalOldPassword))
                                        .findFirst()
                                        .orElse(null);
                                System.out.println("Welcome! " + workingUser.getLogin()
                                        + " you may log out any time, type \'logout\'");
                                try {
                                    workingUser.loadPhoneBook(workingUser, workingUser.getLogin());
                                } catch (FileNotFoundException e) {
                                    workingUser.savePhoneBook(workingUser, workingUser.getLogin());
                                }
                                do {
                                    System.out.println("What do you want to do in your PhoneBook?");
                                    System.out.println("Add contact press 1");
                                    System.out.println("Find contact press 2");
                                    System.out.println("Remove contact press 3");
                                    System.out.println("See all contacts press 4");
                                    answer = buf.readLine();
                                    if (answer.trim().equals("4")) {
                                        System.out.println(workingUser.getPhoneBook());
                                    }
                                    if (answer.trim().equals("1")) {
                                        System.out.println("Enter name");
                                        answer = buf.readLine();
                                        String name = answer.trim();
                                        System.out.println("Enter phone number");
                                        answer = buf.readLine();
                                        String phone = answer.trim();
                                        System.out.println("Enter email");
                                        answer = buf.readLine();
                                        String email = answer.trim();
                                        workingUser.addBookItem(workingUser, new BookItem(
                                                ItemsType.NAME, name, ItemsType.PHONE, phone, ItemsType.EMAIL, email));
                                        System.out.println(workingUser.getPhoneBook());
                                        workingUser.savePhoneBook(workingUser, workingUser.getLogin());
                                    }
                                    if (answer.trim().equals("2")) {
                                        System.out.println("Type name or email or phone of contact");
                                        answer = buf.readLine();
                                        workingUser.findContact(workingUser, answer);
                                    }
                                    if (answer.trim().equals("3")) {
                                        System.out.println("Type name or email or phone of contact");
                                        answer = buf.readLine();
                                        workingUser.removeContact(workingUser, answer);
                                        workingUser.savePhoneBook(workingUser, workingUser.getLogin());
                                    }
                                } while (!answer.trim().equals("logout"));
                            } else {
                                System.out.println("Please, retry to register! You can try " + tryLog);
                                tryLog--;
                                if (tryLog < 0) {
                                    System.out.println("Press Enter to continue log in or siqn up!");
                                    break;
                                }
                            }
                        }
                    } while (workingUser == null);
                } else if (answer.trim().equals("signup")) {
                    do {
                        System.out.println("you need to register, please follow these steps:");
                        System.out.println("Enter your login");
                        answer = buf.readLine();
                        if (answer.trim().equals("exit")) break;
                        if (!answer.equals("")) {
                            newLogin = answer.trim();
                            System.out.println("Enter your password");
                        }
                        answer = buf.readLine();
                        if (answer.trim().equals("exit")) break;
                    } while (answer.equals(""));
                    oldPassword = answer.trim();
                    String finalOldPassword = oldPassword;
                    String finalNewLogin = newLogin;
                    if (User.userList.stream().anyMatch(x -> x.getLogin().equals(finalNewLogin) &
                            x.getPassword().equals(finalOldPassword))) {
                        System.out.println("You are registered user! Press Enter to continue");
                        continue;
                    }
                    if (!answer.trim().equals("exit")) {
                        System.out.println("Confirm your password!");
                    }
                    do {
                        answer = buf.readLine();
                        if (answer.trim().equals("exit")) break;
                        newPassword = answer.trim();
                        if (newPassword.equals(oldPassword)) {
                            System.out.println("Congratulations! You have been registered! Press Enter to continue.");
                            User newUser = new User(newLogin, newPassword);
                            User.addUser(newUser);
                            try {
                                User.saveUser();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Please, confirm your password! You can try" + tryLog);
                            tryLog--;
                            if (tryLog < 0) {
                                System.out.println("Press Enter to continue log in or siqn up!");
                                break;
                            }
                        }
                    } while (!newPassword.equals(oldPassword));
                } else System.out.println("Please, type \'login\' if you are registered or \'signup\' to register, " +
                        "You can always type \'exit\' to exit!");
            } while (!answer.equals("exit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
