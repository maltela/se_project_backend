package de.management.dto;

import java.util.List;

import de.management.entities.Event;

public class EventTOList {

		private List<Event> eventList;
		
		public EventTOList() {
			// TODO Auto-generated constructor stub
		}

		public List<Event> getEventList() {
			return eventList;
		}

		public void setEventList(List<Event> list) {
			this.eventList =list;
		}

}
