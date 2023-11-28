package ANAKIN.MODEL.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import ANAKIN.MODEL.BO.IniciativaBO;
import ANAKIN.MODEL.VO.AuxiliarVO;

public class IniciativaDAO {
	Connection conn;
	PreparedStatement PSTM;
	
	public ArrayList<String> selecionaProtag (){
		conn = new ConexaoDAO().conectabd();
		AuxiliarVO AV = new AuxiliarVO();
		IniciativaBO iniciativa = new IniciativaBO();
		ArrayList<String> nomesProtagonistas = new ArrayList<>();
		ArrayList<String> idProtagonistas = new ArrayList<>();
		ArrayList<Integer> indiciesProtagonista = new ArrayList<>();


		
		String SQL = "select nome_protagonista, id_protagonista from protagonista where id_sessao = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, AV.getIdsessao());
			ResultSet rs = PSTM.executeQuery();
			while(rs.next()){
				String nome = rs.getString(1);
				nomesProtagonistas.add(nome);
				
				int id = rs.getInt(2);
				idProtagonistas = new ArrayList<>();
				
				int indicie = 0;
				indicie += 1;
				
			}
			
			
			iniciativa.iniciativaPerso(nomesProtagonistas);
			PSTM.close();
		} catch (Exception e1) {
			System.err.println("selecionaProtag: "+ e1);
			return null;			
		}
		return nomesProtagonistas;
	}	
	
	public ArrayList<String> selecionaNPC (){
		conn = new ConexaoDAO().conectabd();
		AuxiliarVO AV = new AuxiliarVO();
		IniciativaBO iniciativa = new IniciativaBO();
		ArrayList<String> nomesPersonagens = new ArrayList<>();

	
		String SQL = "select nome_NPC from NPC where id_sessao = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, AV.getIdsessao());
			ResultSet rs = PSTM.executeQuery();
			while(rs.next()){
				String nome = rs.getString(1);
				nomesPersonagens.add(nome);
			}
			
			
			iniciativa.iniciativaPerso(nomesPersonagens);
			PSTM.close();
		} catch (Exception e1) {
			System.err.println("selecionaProtag: "+ e1);
			return null;			
		}
		return nomesPersonagens;
	}
	
	}
