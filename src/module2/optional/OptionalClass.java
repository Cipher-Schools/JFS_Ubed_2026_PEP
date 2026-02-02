package module2.optional;

import java.util.Optional;

class UserService {
    Optional<String> getUserById(int id) {
        if(id == 1) {
            return Optional.of("LPU");
        }
//        else return null;
        return Optional.empty();
    }
}

public class OptionalClass {
    public static void main(String[] args) {
        String name = null;
//        System.out.println(name.length());

        Optional<String> name1 = Optional.ofNullable(null);
        System.out.println(name1);
        System.out.println(name1.isPresent());
        System.out.println(name1.isEmpty());
        System.out.println(name1.orElse("demo name"));      //to assign default value
        System.out.println(name1.orElseGet(()->{return "default name";}));
//        System.out.println(name1.orElseThrow(()->new RuntimeException("throw some error")));    //use runtime exception

        //int, double

        if(name != null) {
            System.out.println(name.length());
        } else System.out.println("value is null");


        UserService userService = new UserService();
        Optional<String> user1 = userService.getUserById(1);
        Optional<String> user2 = userService.getUserById(2);
        System.out.println(user1.get());
        System.out.println(user2.orElse("No value found"));
        System.out.println("end");
    }
}
