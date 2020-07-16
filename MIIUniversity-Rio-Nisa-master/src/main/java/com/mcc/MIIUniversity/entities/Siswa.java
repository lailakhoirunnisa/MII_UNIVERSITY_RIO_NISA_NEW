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
@Table(name = "siswa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Siswa.findAll", query = "SELECT s FROM Siswa s")
    , @NamedQuery(name = "Siswa.findByIdPendaftaran", query = "SELECT s FROM Siswa s WHERE s.idPendaftaran = :idPendaftaran")
    , @NamedQuery(name = "Siswa.findByNis", query = "SELECT s FROM Siswa s WHERE s.nis = :nis")
    , @NamedQuery(name = "Siswa.findByNama", query = "SELECT s FROM Siswa s WHERE s.nama = :nama")
    , @NamedQuery(name = "Siswa.findByAsalSekolah", query = "SELECT s FROM Siswa s WHERE s.asalSekolah = :asalSekolah")
    , @NamedQuery(name = "Siswa.findByJurusan", query = "SELECT s FROM Siswa s WHERE s.jurusan = :jurusan")})
public class Siswa implements Serializable {

    @Size(max = 45)
    @Column(name = "nama")
    private String nama;
    @Size(max = 45)
    @Column(name = "asalSekolah")
    private String asalSekolah;
    @Size(max = 45)
    @Column(name = "jurusan")
    private String jurusan;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPendaftaran")
    private Integer idPendaftaran;
    @Column(name = "nis")
    private Integer nis;

    public Siswa() {
    }

    public Siswa(Integer idPendaftaran) {
        this.idPendaftaran = idPendaftaran;
    }

    public Integer getIdPendaftaran() {
        return idPendaftaran;
    }

    public void setIdPendaftaran(Integer idPendaftaran) {
        this.idPendaftaran = idPendaftaran;
    }

    public Integer getNis() {
        return nis;
    }

    public void setNis(Integer nis) {
        this.nis = nis;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPendaftaran != null ? idPendaftaran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Siswa)) {
            return false;
        }
        Siswa other = (Siswa) object;
        if ((this.idPendaftaran == null && other.idPendaftaran != null) || (this.idPendaftaran != null && !this.idPendaftaran.equals(other.idPendaftaran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcc.MIIUniversity.entities.Siswa[ idPendaftaran=" + idPendaftaran + " ]";
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
}
