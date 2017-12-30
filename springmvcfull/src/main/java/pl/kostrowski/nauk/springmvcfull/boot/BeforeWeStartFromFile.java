package pl.kostrowski.nauk.springmvcfull.boot;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kostrowski.nauk.springmvcfull.model.User;
import pl.kostrowski.nauk.springmvcfull.repository.UserRepository;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author KO
 * Data was taken from https://jsonplaceholder.typicode.com/
 * (I really appreciate Your free database for training)
 * just for training purposes.
 */

@Component
public class BeforeWeStartFromFile implements CommandLineRunner {

    private final String FILE_ADDRESS = "myinit/start.json";

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {

        Gson gson = new Gson();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_ADDRESS).getFile());

        JsonReader reader = new JsonReader(new FileReader(file));
        Type myDataType = new TypeToken<List<User>>() {
        }.getType();
        List<User> users = gson.fromJson(reader, myDataType);

        userRepository.save(users);
    }

}
