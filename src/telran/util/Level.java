package telran.util;

public enum Level {

	//TRACE, DEBUG, INFO, WARN, ERROR;
	TRACE(1), DEBUG(2), INFO(3), WARN(4), ERROR(5);
	int value;
	
	private Level(int value) {	
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	

}
