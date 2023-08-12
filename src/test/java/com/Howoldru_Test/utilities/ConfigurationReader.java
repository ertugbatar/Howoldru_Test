package com.Howoldru_Test.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    // Create the Properties object (create object)
    //make it "private" so we are limiting access to the object
    //"static" is to make sure its created and loaded before everything else.
    private static Properties properties = new Properties();

    static {

        try {
            // Open file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the "properties" object with "file" (load properties)
            properties.load(file);
            //close the file in the memory
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND PATH!!");
            e.printStackTrace();
        }


    }

    //create a utility method to use the object to read
    // Use "properties" object to read from the file (read properties)
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);

    }
}

