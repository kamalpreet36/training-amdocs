package com.amdocs;

public class Main {

	public static void main(String[] args) {

		PaperWala paperWala = new PaperWala("Pune PaperWala Pvt Ltd");
		paperWala.addSubscriber(new Subscriber("Ramesh"));
		paperWala.addSubscriber(new Subscriber("Ram"));
		paperWala.addSubscriber(new Subscriber("Raj"));

		paperWala.notifyAllSubscriber("Times of India");

	}

}
