package app;

/**
 * enum to represent possible values for triage status
 * @author Fergus
 *
 */
public enum Status {

	EMERGENCY ("Emergency"), URGENT ("Urgent"), SEMI_URGENT("Semi-urgent"), NON_URGENT ("Non-urgent"), NOT_ASSESSED ("Not-assessed");
	
	final String name;
	
	Status(String s){
		name = s;
	}
	
	  public boolean equalsName(String otherName){
	        return (otherName == null)? false:name.equals(otherName);
	    }

	    public String toString(){
	       return name;
	    }

	}
	
	

