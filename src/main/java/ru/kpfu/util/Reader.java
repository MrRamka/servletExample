package ru.kpfu.util;

import ru.kpfu.servlets.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<User> readUsers(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);
        List<User> users = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String raw_input = scanner.nextLine();
            String[] items = raw_input.split(",");
            String name = items[0];
            String email = items[1];
            String country = items[3];
            boolean sex = items[4].equals("m");
            String about = items[5];
            boolean consentForDataProcessing = items[6].equals("on");
            users.add(new User(name, email, country, sex, about, consentForDataProcessing));
        }
        return users;
    }
}
