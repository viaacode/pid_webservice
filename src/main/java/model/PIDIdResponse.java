package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PIDIdResponse {
	private String id;
	private int number;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}	
        @Override
	public String toString() {
		return "Pid: " + id + ", " + number;
	}
}
