package com.crudapsjava.bean;

//gets e setters da classe Informacoes
public class Informacoes {
	private int id;
    private String mes;
    private String qtd_petroleo_extraida_mes;
    private String qtd_carbono_liberado_mes;
	
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getQtd_petroleo_extraida_mes() {
		return qtd_petroleo_extraida_mes;
	}
	public void setQtd_petroleo_extraida_mes(String qtd_petroleo_extraida_mes) {
		this.qtd_petroleo_extraida_mes = qtd_petroleo_extraida_mes;
	}
	public String getQtd_carbono_liberado_mes() {
		return qtd_carbono_liberado_mes;
	}
	public void setQtd_carbono_liberado_mes(String qtd_carbono_liberado_mes) {
		this.qtd_carbono_liberado_mes = qtd_carbono_liberado_mes;
	}
	
}
