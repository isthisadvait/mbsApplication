package com.raman.mbs.services;

import java.util.List;

import com.raman.mbs.entities.Status;



public interface StatusService {
	
	/*
	 * Add a new status in the system
	 */
    public Status acceptStatusDetails(Status status);
    
    /*
     * Fetch the status object based on the id
     */
    public Status getStatusBasedOnId(int id) throws Exception;
    /*
     * Fetch the status object based on the status name
     */
    public Status getStatusDetailsByStatusName(String statusName) throws Exception;
    /*
     * delete a status based on Id, returns boolean
     */
    public boolean deleteStatus(int id);
    /*
     * Get all the status
     */
    public List<Status>getAllStatus();
    
    
}
