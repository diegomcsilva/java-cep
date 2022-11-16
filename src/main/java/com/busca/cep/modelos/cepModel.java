package com.busca.cep.modelos;

import org.json.JSONObject;

public class cepModel {
  private String cep;
  private String logradouro;
  private String complemento;
  private String bairro;
  private String localidade;
  private String uf;
  private String ibge;
  private String gia;
  private String ddd;
  private String siafi;

  public cepModel(JSONObject json) {
    this.cep = (String) json.get("cep");
    this.logradouro = (String) json.get("logradouro");
    this.complemento = (String) json.get("complemento");
    this.bairro = (String) json.get("bairro");
    this.localidade = (String) json.get("localidade");
    this.uf = (String) json.get("uf");
    this.ibge = (String) json.get("ibge");
    this.gia = (String) json.get("gia");
    this.ddd = (String) json.get("ddd");
    this.siafi = (String) json.get("siafi");
  }

  public String getCep() {
    return cep;
  }
  public void setCep(String cep) {
    this.cep = cep;
  }
  public String getLogradouro() {
    return logradouro;
  }
  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }
  public String getComplemento() {
    return complemento;
  }
  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }
  public String getBairro() {
    return bairro;
  }
  public void setBairro(String bairro) {
    this.bairro = bairro;
  }
  public String getLocalidade() {
    return localidade;
  }
  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }
  public String getUf() {
    return uf;
  }
  public void setUf(String uf) {
    this.uf = uf;
  }
  public String getIbge() {
    return ibge;
  }
  public void setIbge(String ibge) {
    this.ibge = ibge;
  }
  public String getGia() {
    return gia;
  }
  public void setGia(String gia) {
    this.gia = gia;
  }
  public String getDdd() {
    return ddd;
  }
  public void setDdd(String ddd) {
    this.ddd = ddd;
  }
  public String getSiafi() {
    return siafi;
  }
  public void setSiafi(String siafi) {
    this.siafi = siafi;
  }

  
}
