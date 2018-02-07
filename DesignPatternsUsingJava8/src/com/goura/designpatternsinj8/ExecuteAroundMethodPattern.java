package com.goura.designpatternsinj8;

import java.util.function.Consumer;

public class ExecuteAroundMethodPattern {

	public static void main(String[] args) {
		// Do Something before (resource allocation) and do something after (resource cleanup) you get the handle.
		// And you do your stuffs (doSomething() and doSomethingElse()) in the middle of them.
		Resource.use(resource -> resource
					.doSomething()
					.doSomethingElse());
	}

}

class Resource implements AutoCloseable {

	private Resource() {
		System.out.println("Created...");
	}

	public Resource doSomething() {
		System.out.println("Doing something...");
		return this;
	}

	public Resource doSomethingElse() {
		System.out.println("Doing something else...");
		return this;
	}

	public void close() {
		System.out.println("Cleaning up...");
	}

	public static void use(Consumer<Resource> consumer) {
		try(Resource resource = new Resource()) {
			consumer.accept(resource);
		}
	}
}
