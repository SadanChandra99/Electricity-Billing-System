package com.electricity.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
//import com.electricity.bill.ecxeption.BillException;
//import com.electricity.bill.entity.bill;
import com.electricity.payment.entity.payment;
import com.electricity.payment.exception.PaymentException;
import com.electricity.payment.service.paymentService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class paymentController {
	
	@Autowired
	private paymentService paymentservice;
	
	
	@GetMapping("/v1/payment")
	public List<payment> listAllPayments(){
	//	log.info("entered into getlistAllPayments method in payment controller");
		List<payment> lists = this.paymentservice.getAllPayments();
		System.out.println(lists);
	//	log.info("exited from getlistAllPayments method in payment controller");
		
		return lists;
	}
	
	@PostMapping("/v1/payment" )
	public payment savePayment(@RequestBody payment pay){
	//	log.info("entered into savePayment method in payment controller");
		payment payments = this.paymentservice.savePaymentDetails(pay);
//		log.info("Exited from savePayment method in payment controller");
		
		return payments;
	}
	
	@GetMapping("/v1/payment/{id}")
	public ResponseEntity<Object> getPaymentById(@PathVariable("id") Long paymentId){
		payment consumer;
		//Cart resultCart;
//		log.info("entered into getPaymentById method in payment controller");
        try {
        	consumer = paymentservice.getPaymentById(paymentId);
        	System.out.println(consumer);
        	//log.info("Exited into get method in bill controller");
            return new ResponseEntity<Object>(consumer, HttpStatus.OK);
        } catch (PaymentException e) {
  //      	log.info("Exited from getBillById method in payment controller");
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
		//return null;
		
		
	}
	
	@PutMapping("/v1/payment/{id}")
	public ResponseEntity<Object> updatePayment(@RequestBody payment pay){
	//	log.info("entered into updatePayment method in payment controller");
		payment consumerdto;
		try {
			consumerdto = paymentservice.updatePayment(pay);
			System.out.println(consumerdto);
            return new ResponseEntity<Object>(consumerdto, HttpStatus.OK);
        } catch (PaymentException e) {
  //      	log.info("Exited from update method in payment controller");
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
		
	}
	
	@DeleteMapping("/v1/payment/{id}")
	
	public String deletePayment(@PathVariable("id") Long id){
//		log.info("entered into deletePayment method in payment controller");
		paymentservice.deletePayment(id);
//		log.info("exited from deletePayment method in payment controller");
		return "payment deleted";
		
		
		
	}

}
