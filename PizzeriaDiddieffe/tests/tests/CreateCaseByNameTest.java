package tests;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.core.CreateObjectByName;
import pizzeriadiddieffe.core.Item;

public class CreateCaseByNameTest {
	private  CreateObjectByName myCreator;

	private String toppingName = "Mozzarella";
	private String baseCaseName = "pizza";
	private String baseClassCorrectInfo = "Brown dough pizza";
	private double baseClassCorrectPrice = 3.75;
	private String baseClassName = "BasicBrownPizza";
	private String basePackagePath = "pizzeriadiddieffe.core."+baseCaseName+".";
	private String toppingPackagePath = basePackagePath+"topping.";
	private String correctToppingInfo = baseClassCorrectInfo+", "+toppingName;
	private double toppingPrice = 0.50;
	private double correctToppingPrice = baseClassCorrectPrice+toppingPrice;

	private String currentToppingName;
	private String currentBaseClass;
	private String currentBaseCase;
	private String currentPackagePath;
	private String currentToppingPackagePath;
	private Item myCurrentObject;

	private double deltaFactor = 0.10;

	@Before
	public void setUp(){
		myCreator = new CreateObjectByName();
		resetAll();
	}

	private void resetAll() {
		currentToppingName = null;
		currentBaseClass = null;
		currentBaseCase = null;
		currentPackagePath = null;
		currentToppingPackagePath = null;
		myCurrentObject = null;
	}

	@Test
	public void createCorrectBaseCaseTest() throws Exception {
		setUpCurrentPackage(basePackagePath, toppingPackagePath, baseClassName, currentToppingName);
		returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
	}

	@Test(expected = ClassNotFoundException.class)
	public void WrongPackagePathTest() throws Exception{
		setUpCurrentPackage("", toppingPackagePath, baseCaseName, currentToppingName);
		returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
	}

	@Test()
	public void WrongToppingPackagePathTest() throws Exception{
		setUpCurrentPackage(basePackagePath, "", baseClassName, currentToppingName);
		returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
	}

	@Test(expected = ClassNotFoundException.class)
	public void WrongBaseClassNameTest() throws Exception{
		setUpCurrentPackage(basePackagePath, toppingPackagePath, "", currentToppingName);
		returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
	}

	@Test
	public void correctInfoBaseCaseTest() throws Exception{
		setUpCurrentPackage(basePackagePath, toppingPackagePath, baseClassName, currentToppingName);
		myCurrentObject = returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
		assertEquals(myCurrentObject.getInfo(), baseClassCorrectInfo);
	}

	@Test
	public void correctPriceBaseCaseTest() throws Exception{
		setUpCurrentPackage(basePackagePath, toppingPackagePath, baseClassName, currentToppingName);
		myCurrentObject = returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
		assertEquals(myCurrentObject.getPrice(), baseClassCorrectPrice, deltaFactor);
	}

	@Test
	public void createToppingTest() throws Exception{
		setUpCurrentPackage(basePackagePath, toppingPackagePath, baseClassName, toppingName);
		myCurrentObject = returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
		returnToppingObject(baseCaseName, toppingPackagePath);
	}

	@Test(expected = Exception.class)
	public void wrongToppingBaseClassNameTest() throws Exception{
		setUpCurrentPackage(basePackagePath, toppingPackagePath, "", toppingName);
		myCurrentObject = returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
		returnToppingObject(baseCaseName, toppingPackagePath);
	}

	@Test(expected = Exception.class)
	public void wrongToppingNameClassNameTest() throws Exception{
		setUpCurrentPackage(basePackagePath, toppingPackagePath, baseClassName,"");
		myCurrentObject = returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
		returnToppingObject(baseCaseName, toppingPackagePath);
	}

	@Test
	public void correctToppingInfoTest() throws Exception{
		setUpCurrentPackage(basePackagePath, toppingPackagePath, baseClassName, toppingName);
		myCurrentObject = returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
		myCurrentObject = returnToppingObject(baseCaseName, toppingPackagePath);
		assertEquals(myCurrentObject.getInfo(), correctToppingInfo);
	}

	@Test
	public void correctToppingPriceTest() throws Exception{
		setUpCurrentPackage(basePackagePath, toppingPackagePath, baseClassName, toppingName);
		myCurrentObject = returnBasicObject(currentBaseCase, currentPackagePath+currentBaseCase);
		myCurrentObject = returnToppingObject(baseCaseName, toppingPackagePath);
		assertEquals(myCurrentObject.getPrice(), correctToppingPrice, deltaFactor);
	}

	private void setUpCurrentPackage(String packagePath, String toppingPath, String baseClassName, String currentTopping) {
		currentPackagePath = packagePath;
		currentToppingPackagePath = toppingPath;
		currentBaseCase = baseClassName;
		currentToppingName = currentTopping;
	}

	private Item returnToppingObject(String baseClassName, String fullClassPath) throws Exception {
		currentBaseClass = baseClassName;
		return createToppingObject(fullClassPath);
	}

	private Item returnBasicObject(String baseClassName, String fullClassPath) throws Exception {
		setUpCurrentBaseCase(baseClassName);
		return (Item)createBaseObject(fullClassPath);
	}

	private Item createToppingObject(String classPath) throws Exception{
		return (Item) myCreator.createToppingByName(currentToppingPackagePath+currentToppingName, myCurrentObject, currentBaseClass);
	}

	private Object createBaseObject(String classPath) throws Exception{
		return myCreator.createObjectByName(classPath);
	}

	private void setUpCurrentBaseCase(String baseCase){
		currentBaseCase = baseCase;
	}
}