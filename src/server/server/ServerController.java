package server.server;

import server.client.ClientGUI;

import java.util.ArrayList;
import java.util.List;

public class ServerController {
    private List<ClientGUI> clientGUIList;
    private ServerView view;
    private Repository repository;
    private boolean work;
    public ServerController(ServerView view, Repository repository) {
        this.clientGUIList = new ArrayList<>();
        this.view = view;
        this.repository = repository;
    }

    public boolean connectUser(ClientGUI clientGUI) {

        if (!work){
            return false;
        }
        clientGUIList.add(clientGUI);
        return true;
    }

    public void disconnectUser(ClientGUI clientGUI) {

        clientGUIList.remove(clientGUI);
        if (clientGUI != null){
            clientGUI.disconnectedFromServer();
        }
    }

    public void message(String s) { if (!work){
        return ;
    }
    }


}