
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

import java.util.Random;

public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   public void testManualTest01()
   {  
	   		 String[] schemes = {"http","https"};
			 UrlValidator urlValidator = new UrlValidator(schemes);
			 
			 assertFalse(urlValidator.isValid("ftp://foo.bar.com/"));
   }
   
   public void testManualTest02()
   {  
	   		 String[] schemes = {"http","https"};
			 UrlValidator urlValidator = new UrlValidator(schemes);
			 
			 assertFalse(urlValidator.isValid("://:65a/test1//file?action=view"));			 		
   }
   
   public void testManualTest03()
   {  
	   		 String[] schemes = {"http","https"};
			 UrlValidator urlValidator = new UrlValidator(schemes);
			 
			 assertTrue(urlValidator.isValid("http://www.google.com"));
   }
   
   
   public void testYourFirstPartition()
   {
	   
	   String[] schemes = {"http","https"};
	   UrlValidator urlValidator = new UrlValidator(schemes);
		 
	   for(int i = 0; i < 127; i++) {

			String url = "http://www.google" + (char)i + "com";

			System.out.println(i);
			
			if (i == 46) assertTrue(urlValidator.isValid(url));
			else assertFalse(urlValidator.isValid(url));
		}


   }
   
   public void testYourSecondPartition(){
	   
	   String[] schemes = {"http","https"};
	   UrlValidator urlValidator = new UrlValidator(schemes);
	   
	   for(int i = 0; i < 46; i++) {

			String url = "http://www.google" + (char)i + "com";

			System.out.println(i);
			
			if (i == 46) assertTrue(urlValidator.isValid(url));
			else assertFalse(urlValidator.isValid(url));
		}
		 
	   for(int i = 47; i < 127; i++) {

			String url = "http://www.google" + (char)i + "com";

			System.out.println(i);
			
			if (i == 46) assertTrue(urlValidator.isValid(url));
			else assertFalse(urlValidator.isValid(url));
		}
	   
   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {

	   UrlValidator toTest = new UrlValidator();
	   String result;

	   for (int i = 0; i < 1000; i++) {

	   	result = randomString();
	   	
	   	System.out.println(result);
	   	
	   	if (result.equals("http://www.google.com") || result.equals("http://www.twitter.com") ||
	   		result.equals("http://www.github.com") || result.equals("http://www.oregonstate.edu") ||
	   		result.equals("http://www.stackoverflow.com")) assertTrue(toTest.isValid(result));
	   		
	   	else assertFalse(toTest.isValid(result));
	   } 
   }
   
   public String randomString() {
	   
	   Random rand = new Random();
	   String result = "";

	   int n = rand.nextInt(20)+10;
	   int j = rand.nextInt(2);
	   int f = rand.nextInt(2);

	   if (j == 1) result += "http://www.";
	   else {
	   	for (int i = 0; i < n; i++) {
	   	
	   		int g = rand.nextInt(94)+32;
	   		result += (char)g;
	   	}
	   }

	   if (f == 1) {

	   	int v = rand.nextInt(5);
	   	if (v == 0) result += "google.com";
	   	if (v == 1) result += "twitter.com";
	   	if (v == 2) result += "github.com";
	   	if (v == 3) result += "oregonstate.edu";
	   	if (v == 4) result += "stackoverflow.com";
	   }
	   else {
	   	for (int i = 0; i < n; i++) {
	   	
	   		int g = rand.nextInt(127);
	   		result += (char)g;
	   	}
	   }
	   
	   return result;

   }
   
   
}

