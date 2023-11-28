package ANAKIN.MODEL.BO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


import ANAKIN.MODEL.DAO.IniciativaDAO;

public class IniciativaBO {
	
	public ArrayList<String> iniciativaPerso(ArrayList<String> registroPersonagem){
		Collections.shuffle(registroPersonagem, new Random());
		return registroPersonagem;
	}
	
	
	
	
	
}
