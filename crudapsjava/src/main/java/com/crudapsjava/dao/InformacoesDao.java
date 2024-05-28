package com.crudapsjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudapsjava.bean.Informacoes;

//classe responsável por fazer a conexão com o banco de dados
public class InformacoesDao {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudapsjava","adm","caio");		
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	
	//classe responsável por deletar as informações	
	public static int deletarInformacoes(Informacoes u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM informacoes WHERE id=?");
			ps.setInt(1, u.getId());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
//classe responsável por salvar as informações	
	public static int salvarInformacoes(Informacoes u) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO informacoes (mes, qtd_petroleo_extraida_mes, qtd_carbono_liberado_mes) VALUES (?,?,?)");
			ps.setString(1, u.getMes());
			ps.setString(2, u.getQtd_petroleo_extraida_mes());
			
			ps.setString(3, u.getQtd_carbono_liberado_mes());
			status = ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	
	
	//classe responsável por acessar as informações	pelo ID
	public static Informacoes getRegistroById(int id) {
		Informacoes informacoes = null;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM informacoes WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				informacoes = new Informacoes();
				informacoes.setId(rs.getInt("id"));
				informacoes.setMes(rs.getString("mes"));
				informacoes.setQtd_petroleo_extraida_mes("qtd_petroleo_extraida_mes");
				informacoes.setQtd_carbono_liberado_mes(rs.getString("qtd_carbono_liberado_mes"));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return informacoes;
	}

	
	
	//classe responsável por atualizar as informações		
	public static int updateInformacoes(Informacoes c) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE informacoes SET mes=?, qtd_petroleo_extraida_mes=?, "
					+ "qtd_carbono_liberado_mes=? WHERE id=?");
			ps.setString(1, c.getMes());
			ps.setString(2, c.getQtd_petroleo_extraida_mes());
			ps.setString(3, c.getQtd_carbono_liberado_mes());
			ps.setInt(4, c.getId());
			status = ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	//classe responsável por pegar todas as informações	e adicionar a uma lista
	public static List<Informacoes> getAllInformacoes(){
		List<Informacoes> list = new ArrayList<Informacoes>();
		
		try {
			Connection con = getConnection();
			PreparedStatement  ps = con.prepareStatement("SELECT * FROM informacoes");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Informacoes informacoes = new Informacoes();
				informacoes.setId(rs.getInt("id"));
				informacoes.setMes(rs.getString("mes"));
				informacoes.setQtd_petroleo_extraida_mes(rs.getString("qtd_petroleo_extraida_mes"));
				informacoes.setQtd_carbono_liberado_mes(rs.getString("qtd_carbono_liberado_mes"));
				
				list.add(informacoes);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
