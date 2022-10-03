package Fundamentals;

public interface AppleFormatter {
  
	String accept(Apple a);
}
/*The AppleFormatter is an interface which both the AppleFancyFormatter and AppleSimpleFormtter implements
 * hence since they implement this common interface it can be used for accessing them and executing all their
 * preconditions separately at the same time You’re now able to pass multiple behaviors to your prettyPrintApple
method. You do this by instantiating implementations of AppleFormatter and giving
them as arguments to prettyPrintApple:
 *  */
