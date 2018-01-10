package com.audrius.mivs;

import com.audrius.mivs.model.Admin;
import com.audrius.mivs.model.Student;
import com.audrius.mivs.model.User;
import com.audrius.mivs.utils.IOObjectStreamUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Application {
    static void initialize() {
        Configuration configuration;
        if (!new File("configuration").exists()) {
            createConfigurationFile();
            initializeData();
        } else {
            configuration = getConfigurationFromFile();
            if (doesConfigurationIsNotInitialized(configuration)) {
                initializeData();
            }
        }
    }

    private static void createConfigurationFile() {
        Configuration configuration;
        configuration = new Configuration();
        configuration.setInitialized(true);
        IOObjectStreamUtils.writeObjectToFile("configuration", configuration);
    }

    private static Configuration getConfigurationFromFile() {
        try {
            return  (Configuration) IOObjectStreamUtils.readFirstObjectFromFile("configuration");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean doesConfigurationIsNotInitialized(Configuration configuration) {
        return configuration == null || !configuration.isInitialized();
    }

    private static void initializeData() {
        HashMap<String, User> users = new HashMap<>();
        Admin admin = new Admin("admin", "Super", "Admin", "admin");
        Student student = new Student("student", "Super", "Admin", "admin", "1");
        users.put(admin.getUserName(), admin);
        users.put(student.getUserName(), student);
        IOObjectStreamUtils.writeObjectToFile("users", users);
    }
}
