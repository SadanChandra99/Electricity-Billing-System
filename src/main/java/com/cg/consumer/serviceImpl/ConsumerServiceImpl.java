package com.cg.consumer.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.consumer.entity.Consumer;
import com.cg.consumer.exceptions.ConsumerException;
import com.cg.consumer.repository.ConsumerRepository;
import com.cg.consumer.service.ConsumerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService{
	@Autowired
	ConsumerRepository consumerRepo;

	@Override
	public List<Consumer> getAllConsumer() {
		log.info("list of all consuimers");
		return consumerRepo.findAll();
	}

	@Override
	public Consumer getConsumer(long id) throws ConsumerException {
		log.info("entered into consumer service implementation ");
		Optional<Consumer> Id=consumerRepo.findById(id);
		Consumer consumer = Id.get();
		log.info("exiting into consumer service implementation ");
		//System.out.println(consumer);
		return consumer;
	}

	@Override
	public Consumer saveConsumer(Consumer consumer) {	
		log.info("entered into consumer service implementation ");
		Consumer consumers= consumerRepo.save(consumer);
		log.info("exiting into consumer service implementation ");
		return consumers;
		
	}

	@Override
	public Consumer updateConsumer(Consumer consumer) {	
		log.info("entered into consumer service implementation ");
		Consumer consumers= consumerRepo.save(consumer);
		log.info("exiting into consumer service implementation ");
		return consumers;
	}

	@Override
	public void deleteConsumer(long id) {
		log.info("entered into consumer service implementation ");
		consumerRepo.deleteById(id);
		//return "consumer with " + id + "deleted";
		
	}
	

}
