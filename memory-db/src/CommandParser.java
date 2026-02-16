enum CommandType {
    PUT,    //to add data
    GET,    //to read data
    DELETE, //to delete
    START,
    STOP,
    EXIT    //to exit db
}

class Command {
    CommandType type;
    Integer key;
    String value;
    long ttl;   //optional -> if no ttl then no expiry;
}

public class CommandParser {
    public Command parse(String input) {
        String[] tokens = input.trim().split(" ");

        Command cmd = new Command();
        cmd.type = CommandType.valueOf(tokens[0].toUpperCase());

        if(CommandType.PUT == cmd.type) {
            cmd.key = Integer.parseInt(tokens[1]);
            cmd.value = tokens[2];
            if(tokens.length == 4){
                cmd.ttl = Long.parseLong(tokens[3]);
            } else cmd.ttl = -1; // no expiry
        }

        else if(CommandType.GET == cmd.type ||
                CommandType.DELETE == cmd.type ) {
            cmd.key = Integer.parseInt(tokens[1]);
        }
        return cmd;
    }
}


