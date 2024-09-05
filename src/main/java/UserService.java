public class UserService {
    public String getUserName(){
        return "Real User";
    }

    public String getUserGreeting(){
        return "Hello " + getUserName();
    }
}
