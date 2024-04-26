package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.SpringConsoleConfig;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

public class App {


    public static void main(String[] args) {
        // Создаем контекст приложения на основе конфигурации SpringConsoleConfig
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConsoleConfig.class);

        // Получаем бин UserRepository из контекста
        UserRepository userRepository = context.getBean(UserRepository.class);

        // Выполняем запрос к репозиторию
        List<User> userList = userRepository.findByAgeAndNameContaining(20, "1");

        // Выводим результат запроса
        userList.forEach(System.out::println);

        // Закрываем контекст приложения
        context.close();
    }
}

