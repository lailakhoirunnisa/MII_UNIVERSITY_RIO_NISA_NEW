/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.MIIUniversity.services;

import com.mcc.MIIUniversity.entities.Fakultas;
import com.mcc.MIIUniversity.repositories.FakultasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laila
 */
@Service
public class FakultasService implements IFakultasService{
    
    @Autowired
    FakultasRepository fakultasRepository;
    
    //read
 public List<Fakultas> getAll(){
     return fakultasRepository.findAll();
 }
 //create/update
 public void save(Fakultas fakultas){
     fakultasRepository.save(fakultas);
     
 }
 //delete
 public void delete (String id){
     fakultasRepository.delete(new Fakultas(id));
 }
 public Fakultas getById(String nama){
     return fakultasRepository.findById(nama).get();
 }

//    
//    public Optional<Fakultas> findById(String nama) {
//    return fakultasRepository.findById(nama);
//    }

//since we dont need search, lets just comment it
 
 
//public List<Fakultas> listAll(String keyword){
//    if(keyword !=null){
//        return fakultasRepository.search(keyword);
//    }
//    return fakultasRepository.findAll();
//}

//    @Override
//    public List<Fakultas> search(String keyword) {
//        List<Fakultas> fakultass = (List<Fakultas>) fakultasRepository.search(keyword);
//        return fakultass;
//  
//    }


   
}
