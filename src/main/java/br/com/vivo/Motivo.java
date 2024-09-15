package br.com.vivo;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Motivo extends PanacheEntity {

  public String titulo;
  public String descricao;
  public String imagem;

}
