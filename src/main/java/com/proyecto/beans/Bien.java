package com.proyecto.beans;

import java.io.Serializable;

import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bien")
public  class Bien implements Serializable {


    @Column(name="nombre",table="bien",length=45)
    @Basic
    private String nombre;


    @Column(name="id",table="bien",nullable=false,length=45)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @OneToMany(targetEntity=DetalleBienCampo.class,mappedBy="bien")
    private List<DetalleBienCampo> detalleBienCampoList;


    @Column(name="descripcion",table="bien",length=45)
    @Basic
    private String descripcion;


    @ManyToOne(optional=false,targetEntity=Clase.class)
    @JoinColumn(name="clase_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Clase clase;


    @Column(name="fecha_ingreso",table="bien")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fechaIngreso;


    @Column(name="foto",table="bien",length=45)
    @Basic
    private String foto;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Inventario.class,mappedBy="bien")
    private List<Inventario> inventarios;

    public Bien(){

    }


   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public List<DetalleBienCampo> getDetalleBienCampoList() {
        return this.detalleBienCampoList;
    }


  public void setDetalleBienCampoList (List<DetalleBienCampo> detalleBienCampoList) {
        this.detalleBienCampoList = detalleBienCampoList;
    }



   public String getDescripcion() {
        return this.descripcion;
    }


  public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }



   public Clase getClase() {
        return this.clase;
    }


  public void setClase (Clase clase) {
        this.clase = clase;
    }



   public Date getFechaIngreso() {
        return this.fechaIngreso;
    }


  public void setFechaIngreso (Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }



   public String getFoto() {
        return this.foto;
    }


  public void setFoto (String foto) {
        this.foto = foto;
    }



   public List<Inventario> getInventarios() {
        return this.inventarios;
    }


  public void setInventarios (List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

}

