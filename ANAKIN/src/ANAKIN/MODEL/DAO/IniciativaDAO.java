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
	
	public ArrayList<String> nomeProtag (){
		conn = new ConexaoDAO().conectabd();
		AuxiliarVO AV = new AuxiliarVO();
		ArrayList<String> nomeProtagonistas = new ArrayList<>();

		String SQL = "select nome_protagonista from protagonista where id_sessao = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, AV.getIdsessao());
			ResultSet rs = PSTM.executeQuery();
			while (rs.next()) {
				String nome = rs.getString(1);
				nomeProtagonistas.add(nome);

			}
			PSTM.close();
		} catch (Exception e1) {
			System.err.println("nomeProtag: " + e1);
			return null;
		}
		return nomeProtagonistas;
	}
	
	public ArrayList<String> nomeNPC (){
		conn = new ConexaoDAO().conectabd();
		AuxiliarVO AV = new AuxiliarVO();
		ArrayList<String> nomeNPC = new ArrayList<>();

		String SQL = "select nome_NPC from NPC where id_sessao = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, AV.getIdsessao());
			ResultSet rs = PSTM.executeQuery();
			while (rs.next()) {
				String nome = rs.getString(1);
				nomeNPC.add(nome);

			}
			PSTM.close();
		} catch (Exception e1) {
			System.err.println("nomeNPC: " + e1);
			return null;
		}
		return nomeNPC;
	}
	
	public ArrayList<String> listaGeral (){
		AuxiliarVO AV = new AuxiliarVO();
		IniciativaDAO inicDAO = new IniciativaDAO();
		IniciativaBO iniBO = new IniciativaBO();
		ArrayList<String> listaGeral = new ArrayList<>();
		ArrayList<String> listaProtag = new ArrayList<>();
		ArrayList<String> listaNPC = new ArrayList<>();

		listaProtag.addAll(inicDAO.nomeProtag());
		listaNPC.addAll(inicDAO.nomeNPC());
		
		listaGeral.addAll(listaProtag);
		listaGeral.addAll(listaNPC);
		iniBO.iniciativaGeral(listaGeral);
		return listaGeral;
	}
 	
	public ArrayList<Integer> selecionaProtag() {
		conn = new ConexaoDAO().conectabd();
		IniciativaBO iniciativa = new IniciativaBO();
		AuxiliarVO AV = new AuxiliarVO();
		ArrayList<Integer> idProtagonistas = new ArrayList<>();

		String SQL = "select id_protagonista from protagonista where id_sessao = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, AV.getIdsessao());
			ResultSet rs = PSTM.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				idProtagonistas.add(id);

			}
			iniciativa.iniciativaProtag(idProtagonistas);
			PSTM.close();
		} catch (Exception e1) {
			System.err.println("selecionaProtag: " + e1);
			return null;
		}
		return idProtagonistas;
	}

	public ArrayList<Integer> selecionaNPC() {
		conn = new ConexaoDAO().conectabd();
		IniciativaBO iniciativa = new IniciativaBO();
		AuxiliarVO AV = new AuxiliarVO();
		ArrayList<Integer> idNPC = new ArrayList<>();

		String SQL = "select id_npcs from npc where id_sessao = ?;";
		try {
			PSTM = conn.prepareStatement(SQL);
			PSTM.setInt(1, AV.getIdsessao());
			ResultSet rs = PSTM.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				idNPC.add(id);

			}
			iniciativa.iniciativaNPC(idNPC);
			PSTM.close();
		} catch (Exception e1) {
			System.err.println("selecionaNPC: " + e1);
			return null;
		}
		return idNPC;
	}
	
	public ArrayList<Integer> listaIdGeral (){
		AuxiliarVO AV = new AuxiliarVO();
		IniciativaDAO inicDAO = new IniciativaDAO();
		ArrayList<Integer> listaGeral = new ArrayList<>();
		ArrayList<Integer> listaProtag = new ArrayList<>();
		ArrayList<Integer> listaNPC = new ArrayList<>();

		listaProtag.addAll(inicDAO.selecionaProtag());
		listaNPC.addAll(inicDAO.selecionaNPC());
		
		listaGeral.addAll(listaProtag);
		listaGeral.addAll(listaNPC);
		
		return listaGeral;
	}

}
