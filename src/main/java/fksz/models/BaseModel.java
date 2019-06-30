package fksz.models;

public class BaseModel {
	String severNotification;
	String notificationType;
	
	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getSeverNotification() {
		return severNotification;
	}

	public void setSeverNotification(String severNotification) {
		this.severNotification = severNotification;
	}
	
	public void setNotification(String notification, String notificationType) {
		this.severNotification = notification;
		this.notificationType = notificationType;
	}

}
