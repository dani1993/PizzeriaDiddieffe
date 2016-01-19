package pizzeriadiddieffe.core;

public interface ItemsCreatorInterface {
	public Object createObjectByName (String className) throws Exception;
	public Object createToppingByName(String className, Item baseItem, String type) throws Exception;
}