package com.goura.designpatternsinj8;

import java.util.function.Consumer;

public class BulderPattern {

	public static void main(String[] args) {
		Mailer.send(mailer -> mailer
			.from("someone@source.com")
			.to("me@target.com")
			.subject("Party time")
			.body("... Are you coming to the party?..."));
	}

}

class Mailer {

	public static void print(String msg) {
		System.out.println(msg);
	}

	public Mailer from(String from) {
		System.out.println("From: " + from);
		return this;
	}

	public Mailer to(String to) {
		System.out.println("To: " + to);
		return this;
	}

	public Mailer subject(String subject) {
		System.out.println("Subject: " + subject);
		return this;
	}

	public Mailer body(String msg) {
		System.out.println("Body: " + msg);
		return this;
	}

	public static void send(Consumer<Mailer> consumer) {
		Mailer mailer = new Mailer();
		consumer.accept(mailer);
		System.out.println("Sending...");
	}
}
