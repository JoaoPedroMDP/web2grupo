package br.ufpr.tads.web2.util;

/**
 * @author LucasRC
 */
public class Config {
  public String database;
  public String user;
  public String password;
  public String host;
  public String port;

  // COPIE ESTE ARQUIVO E RENOMEIE A CÓPIA PARA Config,java
  // NELA, SUBSTITUA OS ITENS ABAIXO PELOS SEUS DADOS
  public Config() {
    this.database = "DATABASE";
    this.user = "developer";
    this.password = "1234567";
    this.host = "beibe";
    this.port = "3306";
  }
}
