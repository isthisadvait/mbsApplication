package com.raman.mbs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raman.mbs.dtos.DemoDTO;

/*
 * I need to tell the spring that this class is a controller class,bean has to be ready .
 * URI -> 127.0.0.1:7070/mbs/v1/demos
 * 
 */
@RestController
@RequestMapping("/mbs/v1/demos")
public class DemoController {
	
	/*
	 * GET 127.0.0.1:7070/mbs/v1/demos
	 * return as response ->This is a Movie Booking Application
	 */
	@GetMapping
	public ResponseEntity getDemoResponse() {
		return new ResponseEntity("This is a Movie Booking Application.",HttpStatus.OK);
	}
	/*
	 * GET 127.0.0.1:7070/mbs/v1/demos/{demo_id}
	 * {demo_id} is path param.
	 * return as response -> demo_id
	 */
	@GetMapping("/{demo_id}")
	public ResponseEntity getDemoResponseBasedOnId(@PathVariable("demo_id") int demoId) {
		return new ResponseEntity("This is a demo id."+ demoId,HttpStatus.OK);
	}
    
	/*
	 * Create a new demo
	 * POST http://127.0.0.1:8080/mbs/v1/demos
	 * There should be RequestBody which contains the data .It covert the object in json.
	 * {
	 *    "demo_name" : "Qwery"
	 *    "demo_id"   : "1233"
	 *    "demo_desc" : "Fan "
	 * }
	 */
	
	@PostMapping 
	public ResponseEntity creayeDemo(@RequestBody DemoDTO demoDTO) {
		System.out.println(demoDTO);
		return new ResponseEntity(" Demo Object Created ",HttpStatus.CREATED);
		
	}
	/*
	 * update demo object
	 */
	@PutMapping
	public ResponseEntity updateDemo(@RequestBody DemoDTO demoDTO) {
		System.out.println(demoDTO);
		return new ResponseEntity(" Demo Object Modified ",HttpStatus.ACCEPTED);
		
	}
	/*
	 * Delete call
	 */
	@DeleteMapping("/{demo_id}")
	public ResponseEntity deleteDemo(@PathVariable("demo_id") int demoId) {
	
		return new ResponseEntity(" Demo Object deleted with id " + demoId,HttpStatus.OK);
		
	}
	

}
