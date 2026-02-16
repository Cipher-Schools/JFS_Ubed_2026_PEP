import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CommandParser parser = new CommandParser();
        DB db = new DB();

        while(true) {
            try {
                String input = scanner.nextLine();
                if(input.trim().isEmpty()) continue;

                Command cmd = parser.parse(input);

                switch (cmd.type) {
                    case PUT:
                        db.put(cmd.key, cmd.value, cmd.ttl);
                        break;
                    case GET:
                        System.out.println(db.get(cmd.key));
                        break;
                    case DELETE:
                        db.delete(cmd.key);
                        break;
                    case START:
                        db.start();
                        break;
                    case STOP:
                        db.stop();
                        break;
                    case EXIT:
                        db.stop();
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error processing command: " + e.getMessage());
            }
        }
    }
}
