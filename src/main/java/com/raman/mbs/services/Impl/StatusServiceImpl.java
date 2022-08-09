package com.raman.mbs.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raman.mbs.daos.StatusDao;
import com.raman.mbs.entities.Status;
import com.raman.mbs.exceptions.StatusDetailsNotFoundException;
import com.raman.mbs.services.StatusService;



@Service
public class StatusServiceImpl implements StatusService{
	
	@Autowired
	private StatusDao statusDao;
	
    /*
     * Given a status store it into databases
     */
	
	public Status acceptStatusDetails(Status status) {

		return statusDao.save( status);
	}
	
    /*
     * Based on Id status should be returned
     * if valid id ,status should be returned 
     * if Invalid id , StatusDetailsNotFoundException should be returned
     */
	public Status getStatusBasedOnId(int id) throws Exception {
		Status savedStatus = 
		statusDao.findById(id).orElseThrow(()->new StatusDetailsNotFoundException("Status Not found for provided status id"));
		
		return savedStatus;
		
	        
	}
	


	public Status getStatusDetailsByStatusName(String statusName) throws Exception {
		Status savedStatus = statusDao.findByStatusName(statusName);
		
		if(savedStatus == null) {
			throw new StatusDetailsNotFoundException("Status Not found for provided status name");
		}
		
		return savedStatus;
	}
	
	/*
	 * return true if able to delete successfully
	 * 
	 */
      
	public boolean deleteStatus(int id) {
	   
		statusDao.deleteById(id);
		return true;
	}
	

	public List<Status> getAllStatus() {
		List<Status> statuses = statusDao.findAll();
		return statuses;
	}
	

}
