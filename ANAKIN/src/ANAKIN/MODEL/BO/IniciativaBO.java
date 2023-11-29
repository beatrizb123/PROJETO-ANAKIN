package ANAKIN.MODEL.BO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import ANAKIN.MODEL.DAO.IniciativaDAO;
public class IniciativaBO {
	
	public ArrayList<Integer> iniciativaProtag(ArrayList<Integer> registroProtag){
		Collections.shuffle(registroProtag, new Random());
		return registroProtag;
	}
	
	public ArrayList<Integer> iniciativaNPC(ArrayList<Integer> registroNPC){
		Collections.shuffle(registroNPC, new Random());
		return registroNPC;
	}
	public ArrayList<String> iniciativaGeral(ArrayList<String> registroG){
		Collections.shuffle(registroG, new Random());
		return registroG;
	}
	
}
