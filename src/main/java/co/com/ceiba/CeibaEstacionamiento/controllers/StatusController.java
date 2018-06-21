/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ceiba.CeibaEstacionamiento.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manuela
 */

@RestController
@RequestMapping(value = "/")
public class StatusController {
    
    @GetMapping("/status")
    public String status(){
        return "Running Server";
    }
    
}
