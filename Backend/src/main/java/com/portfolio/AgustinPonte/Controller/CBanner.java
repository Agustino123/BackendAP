/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.AgustinPonte.Controller;

import com.portfolio.AgustinPonte.Dto.dtoBanner;
import com.portfolio.AgustinPonte.Entity.Banner;
import com.portfolio.AgustinPonte.Security.Controller.Mensaje;
import com.portfolio.AgustinPonte.Service.SBanner;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
//@CrossOrigin(origins = "https://frontendap-e4d5c.web.app")
@CrossOrigin(origins = {"https://frontendap-e4d5c.web.app","http://localhost:4200"})
public class CBanner {
    
    @Autowired
    SBanner sBanner;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> list(){
        List<Banner> list = sBanner.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id")int id){
        if(!sBanner.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Banner banner = sBanner.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBanner dtobanner){
        if(!sBanner.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        Banner banner = sBanner.getOne(id).get();
        
        banner.setImgB(dtobanner.getImgB());
        
        sBanner.save(banner);
        
        return new ResponseEntity(new Mensaje("Banner actualizada"), HttpStatus.OK);
    }
    
}
