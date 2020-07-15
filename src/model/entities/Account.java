package model.entities;

import model.exception.DomainException;

public class Account{
	private Integer numero;
	private String nomeCliente;
	private Double saldoConta;
	private Double limiteSaque;
	
	public Account() {
	}

	public Account(Integer numero, String nomeCliente, Double saldoConta, Double limiteSaque) {
		this.numero = numero;
		this.nomeCliente = nomeCliente;
		this.saldoConta = saldoConta;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getSaldoConta() {
		return saldoConta;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}
	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public void deposito(double valor) {
		saldoConta += valor;
	}
	
	public void saque(double valor) {
		if(valor > getLimiteSaque()) {
			throw new DomainException("Erro no saque: Valor solicitado é superior ao limite de saque.");
		}
		if(valor > getSaldoConta()) {
			throw new DomainException("Erro no saque: Valor solicitado é superior ao saldo da conta.");
		}
		saldoConta -= valor;
	}
	
	@Override
	public String toString() {
		return "Saldo da conta: R$ "+String.format("%.2f", getSaldoConta());
	}
}
