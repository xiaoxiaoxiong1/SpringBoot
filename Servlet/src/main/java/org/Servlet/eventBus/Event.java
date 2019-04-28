package org.Servlet.eventBus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event extends  EventAbstract {
/*	public Event() {
	}

	public Event(String message) {
		this.message = message;
	}*/

	/* @NonNull */
	private String message;
	
	private String name;

/*	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}*/

}
