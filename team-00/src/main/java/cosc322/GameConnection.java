/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc322;

import java.util.ArrayList;
import java.util.Map;

import ygraphs.ai.smart_fox.GameMessage;
import ygraphs.ai.smart_fox.games.AmazonsGameMessage;
import ygraphs.ai.smart_fox.games.GameClient;
import ygraphs.ai.smart_fox.games.GamePlayer;
/**
 *
 * @author drews
 */
public class GameConnection extends GamePlayer{
    
    private String userName = null;
    private GameClient gameClient;
    
    public static void main(String[] args) {				 
	COSC322Test player_01 = new COSC322Test(args[0], args[1]);  		 
    }
    
    public GameConnection(String username, String pwrd){
        this.userName = username;
        gameClient = new GameClient(userName, pwrd, this);	
    }
    
    @Override
    public boolean handleGameMessage(String messageType, Map<String, Object> msgDetails) {
	
	return true;
    }

    @Override
    public void onLogin() {
	System.out.println("Login Successfuly");
	this.gameClient.logout();
    }
    
    @Override
    public String userName() {
	return userName;
    }
}
