/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.MIIUniversity.controller;

import com.mcc.MIIUniversity.entities.Fakultas;
import com.mcc.MIIUniversity.repositories.FakultasRepository;
import com.mcc.MIIUniversity.services.FakultasService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Laila
 */
@Controller
public class FakultasController {
    @Autowired
    FakultasService fakultasService;
    FakultasService fakultasService1;
    
@Autowired
    FakultasRepository fakultasRepository;
    
    @GetMapping("")
public String index( Model model){
   model.addAttribute("fakultas", new Fakultas());
    model.addAttribute("fakultass", fakultasService.getAll());
   
    return "index";
}
@PostMapping("/save")
public String save(@Valid Fakultas fakultas){
    fakultasService.save(fakultas);
    
    return "redirect:/";
    
    
}

@PostMapping("/update")
public String save(@RequestParam ("id") String id, @Valid Fakultas fakultas, BindingResult result, Model model){
    if(result.hasErrors()){
        fakultas.setId(id);
        return "index";
    }
    fakultasRepository.save(fakultas);
    model.addAttribute("fakultas", fakultas);
    return "index";
        
//         .orElseThrow(() - > new IllegalArgumentException("Invalid Fakultas ID:"+id));
// model.addAttribute("fakultas", fakultas);
//    fakultasService.save(fakultas);
//    
//    return "redirect:/";
//    
    
}

@RequestMapping("/delete/{id}")
public String delete(@PathVariable String id){
    fakultasService.delete(id);
    return "redirect:/";
    
}
@RequestMapping("{id}")
public String getById(Model model, @PathVariable("nama") String nama){
model.addAttribute("fakultas", fakultasService.getById(nama));
model.addAttribute("fakultass", fakultasService.getAll());
//    Optional<Fakultas> fakultas= fakultasRepository.findAllById(id);
//fakultas.addAttribute("fakultas", new Fakultas()); 
//return fakultasService.getById(id);
     return "index";
    
//    if (fakultas.isPresent()) {
//      return new ResponseEntity<>(fakultas.get(), HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
  }

//@RequestMapping("/search")
//public String viewHomePage(Model model){
//String keyword="a";
//    List<Fakultas> listFakultass= fakultasService.listAll(keyword);
//    model.addAttribute("listFakultass", listFakultass);
////    model.addAttribute("keyword", keyword);
//    return "index";
//}

//@GetMapping("/search")
//public String search (Model model, @RequestParam String keyword){
//        List<Fakultas> fakultass = (List<Fakultas>) fakultasRepository.search(keyword);
//    model.addAttribute("fakultass", fakultass);
//    return "showSearch";
//}

}
