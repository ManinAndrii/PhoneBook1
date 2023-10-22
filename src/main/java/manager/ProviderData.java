package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO() { //Data Transfer Object =DTO
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                User.builder()
                        .email("skrydj1984@mail.com")
                        .password("Ll12345$")
                        .build()

        });
        list.add(new Object[]{
                User.builder()
                        .email("skrydj2023@mail.com")
                        .password("Li12345$")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactDTO() { //Data Transfer Object =DTO
        List<Object[]> list = new ArrayList<>();
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        list.add(new Object[]{
                Contact.builder()
                        .name("Jhon_"+i)
                        .lastName("Pig")
                        .phone("123456"+i)
                        .address("Los-Pedros")
                        .description("to")
                        .email("Jhon_"+i+"@mail.com")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Jhon_"+i)
                        .lastName("Pig")
                        .phone("123456"+i)
                        .address("Los-Pedros")
                        .description("to")
                        .email("Jhon_"+i+"@mail.com")
                        .build()
        });
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> registrationCSV() throws IOException { // Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/reg_dataset.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{
                    User.builder()
                            .email(split[0])
                            .password(split[1])
                            .build()
            });
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
}




