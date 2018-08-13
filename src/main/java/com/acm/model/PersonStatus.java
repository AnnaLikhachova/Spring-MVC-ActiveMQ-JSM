package com.acm.model;

public enum PersonStatus {
	CREATED("Created"),
	DELETED("Deleted"),
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    FAILED("Failed");
     
      
    private String status;
      
    private PersonStatus(final String status){
        this.status = status;
    }
      
    public String getStatus(){
        return this.status;
    }
  
    @Override
    public String toString(){
        return this.status;
    }
  
  
    public String getName(){
        return this.name();
    }
}