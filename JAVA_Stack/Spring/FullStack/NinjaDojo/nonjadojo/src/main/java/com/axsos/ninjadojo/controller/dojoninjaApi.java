//package com.axsos.ninjadojo.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.axsos.ninjadojo.services.DojoServices;
//import com.axsos.ninjadojo.services.NinjaServices;
//
//import com.axsos.ninjadojo.models.*;
//
//@RestController
//public class dojoninjaApi {
//	private final NinjaServices ninjaServices;
//
//	public dojoninjaApi(NinjaServices ninjaServices) {
//		this.ninjaServices=ninjaServices;
//		this.dojoServices = null;
//	}
//	public dojoninjaApi(DojoServices dojoServices) {
//		this.ninjaServices = null;
//		this.dojoServices=dojoServices;
//	}
////	show all dojos
//
//// show all ninja
//	@RequestMapping("/api/ninja")
//	public List<Ninja> addNinja(){
//		return ninjaServices.allNinja() ;
//	}
//	
////	post method to add dojo
//	
//
////	post method to add ninja
//    @RequestMapping(value="/api/dojo", method=RequestMethod.POST)
//    public Ninja createNinja(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName,
//    		@RequestParam(value="age") int age) {
//       Ninja ninja = new Ninja(firstName,lastName,age );
//        return ninjaServices.createNinja(ninja);
//    }
//	
//	
//	
//	
//	
//}
