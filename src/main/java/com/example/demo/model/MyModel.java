package com.example.demo.model;

public class MyModel {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || obj.getClass() != this.getClass())
			return false;

		MyModel model = (MyModel) obj;

		return (model.message.equals(this.message) && model.message == this.message);
	}

	@Override
	public int hashCode() {

		return this.message.hashCode();
	}

}
