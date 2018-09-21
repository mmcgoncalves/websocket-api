package websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import websocket.model.Notifications;

@RestController
public class NotificationController {
	
	@Autowired
	private SimpMessagingTemplate template;

	private Notifications notifications = new Notifications(0);

	@GetMapping("/api/notify")
	public String getNotification() {

		notifications.increment();

		template.convertAndSend("/api/topic/notification", notifications);

		return "Notifications successfully sent to Angular !";
	}

}
