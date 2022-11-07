package com.axsos.ninjadojo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.ninjadojo.models.Dojo;
import com.axsos.ninjadojo.services.DojoServices;

public class DojoApi {
	private final DojoServices dojoServices;
	
	public DojoApi(DojoServices dojoServices) {
		this.dojoServices=dojoServices;
	}
	
	@RequestMapping("/api/dojo")
	public List<Dojo> addDojo(){
		return dojoServices.allDojos();
	}
	
    @RequestMapping(value="/api/dojo", method=RequestMethod.POST)
    public Dojo create(@RequestParam(value="name") String name) {
        Dojo dojo = new Dojo(name);
        return dojoServices.createDojo(dojo);
    }

}
