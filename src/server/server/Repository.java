package server.server;

public interface Repository {
    String readLog();
    void saveLog(String text);
}


