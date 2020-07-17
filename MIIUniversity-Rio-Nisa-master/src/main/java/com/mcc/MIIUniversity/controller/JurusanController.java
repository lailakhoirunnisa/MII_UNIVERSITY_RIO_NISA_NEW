/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.MIIUniversity.controller;

import com.mcc.MIIUniversity.entities.Jurusan;
import com.mcc.MIIUniversity.repositories.JurusanRepository;
import com.mcc.MIIUniversity.services.JurusanService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Laila
 */
@Controller
public class JurusanController {

    @Autowired
    JurusanService jurusanService;

    @Autowired
    JurusanRepository jurusanRepository;

    @GetMapping("/jurusan")
    public String index(Model model) {
        model.addAttribute("jurusan", new Jurusan());
        model.addAttribute("jurusans", jurusanService.getAll());

        return "jurusan";
    }
@PostMapping("/jurusansave")
public String save(@Valid Jurusan jurusan){
    jurusanService.save(jurusan);
    
    return "redirect:/jurusan/";
    
    
}

//@PostMapping("/update")
//public String save(@RequestParam ("id") String id, @Valid Jurusan jurusan, BindingResult result, Model model){
//    if(result.hasErrors()){
//        jurusan.setId(id);
//        return "index";
//    }
//    jurusanRepository.save(jurusan);
//    model.addAttribute("jurusan", jurusan);
//    return "index";
//        
//         .orElseThrow(() - > new IllegalArgumentException("Invalid Jurusan ID:"+id));
// model.addAttribute("jurusan", jurusan);
//    jurusanService.save(jurusan);
//    
//    return "redirect:/";
//    
    
//}

@RequestMapping("/jurusandelete/{id}")
public String delete(@PathVariable String id){
    jurusanService.delete(id);
    return "redirect:/jurusan/";
    
}
@RequestMapping("/jurusan/{id}")
public String getById(Model model, @PathVariable("nama") String nama){
model.addAttribute("jurusan", jurusanService.getById(nama));
model.addAttribute("jurusans", jurusanService.getAll());
//    Optional<Jurusan> jurusan= jurusanRepository.findAllById(id);
//jurusan.addAttribute("jurusan", new Jurusan()); 
//return jurusanService.getById(id);
     return "index";
    
//    if (jurusan.isPresent()) {
//      return new ResponseEntity<>(jurusan.get(), HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
  }

//@RequestMapping("/search")
//public String viewHomePage(Model model){
//String keyword="a";
//    List<Jurusan> listJurusans= jurusanService.listAll(keyword);
//    model.addAttribute("listJurusans", listJurusans);
////    model.addAttribute("keyword", keyword);
//    return "index";
//}

//@GetMapping("/search")
//public String search (Model model, @RequestParam String keyword){
//        List<Jurusan> jurusans = (List<Jurusan>) jurusanRepository.search(keyword);
//    model.addAttribute("jurusans", jurusans);
//    return "showSearch";
//}

}

   

