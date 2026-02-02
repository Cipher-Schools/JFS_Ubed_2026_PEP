package project;

public final class LoggerClass {

    public enum Level {
        ERROR, WARNING, INFO
    }

    private LoggerClass() {}

    private static void log(Level level, String msg) {

        if (msg == null) { msg = "null"; }

        String output = DateTimeUtil.getDateTime() + " [" + level + "] " + msg;

        if (level == Level.ERROR) {
            System.err.println(output);
        } else {
            System.out.println(output);
        }
    }
}
