/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.MIIUniversity.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laila
 */
@Entity
@Table(name = "jurusan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jurusan.findAll", query = "SELECT j FROM Jurusan j")
    , @NamedQuery(name = "Jurusan.findByNama", query = "SELECT j FROM Jurusan j WHERE j.nama = :nama")
    , @NamedQuery(name = "Jurusan.findByFakultas", query = "SELECT j FROM Jurusan j WHERE j.fakultas = :fakultas")})
public class Jurusan implements Serializable {

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "fakultas")
    private String fakultas;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nama")
    private String nama;

    public Jurusan() {
    }

    public Jurusan(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nama != null ? nama.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jurusan)) {
            return false;
        }
        Jurusan other = (Jurusan) object;
        if ((this.nama == null && other.nama != null) || (this.nama != null && !this.nama.equals(other.nama))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.MIIUniversity.entities.Jurusan[ nama=" + nama + " ]";
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    
}
