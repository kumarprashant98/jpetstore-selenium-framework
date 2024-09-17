package datafactory;

import dataobject.UserInformation;
import utilities.JavaHelpers;

public class UserInformationData {
    UserInformation userInfo = new UserInformation();
    JavaHelpers javaHelpers = new JavaHelpers();

    public UserInformation UserInformation(){

        userInfo.setUserId("Tester"+javaHelpers.getRandomNumber(4));
        userInfo.setNewPassword("Tester@12345");
        userInfo.setRepeatPassword("Tester@12345");
        userInfo.setFirstName("Automation");
        userInfo.setLastName("Tester");
        userInfo.setEmail(javaHelpers.getAlphaNumericString(4)+"@gmail.com");
        userInfo.setPhone("9425252525");
        userInfo.setAddress1("A-010 baker street");
        userInfo.setAddress2("near wall-mart circle");
        userInfo.setCity("Ahmedabad");
        userInfo.setState("Gujarat");
        userInfo.setZip("1044");
        userInfo.setCountry("India");
        userInfo.setLanguage("english");
        userInfo.setAnimal("CATS");

        return userInfo;
    }
    public UserInformation InvalidUserData(){
        userInfo.setUserId("Tester"+javaHelpers.getRandomNumber(4));
        userInfo.setNewPassword("@#$@#$@#$");
        userInfo.setRepeatPassword("@#$@#$@#$");
        userInfo.setFirstName("123456");
        userInfo.setLastName("789456");
        userInfo.setEmail(javaHelpers.getAlphaNumericString(4)+"gmail.com");
        userInfo.setPhone("PhoneNumber");
        userInfo.setAddress1("A-010 baker street");
        userInfo.setAddress2("near wllmart circle");
        userInfo.setCity("india");
        userInfo.setState("Asia");
        userInfo.setZip("%$%$");
        userInfo.setCountry("goa");
        userInfo.setLanguage("english");
        userInfo.setAnimal("CATS");
        return userInfo;
    }
    public UserInformation DifferentDataInPasswordAndConfirmPassword(){
        userInfo.setUserId("Tester"+javaHelpers.getRandomNumber(4));
        userInfo.setNewPassword("Tester@12345");
        userInfo.setRepeatPassword("Tester@789456");
        userInfo.setFirstName("Automation");
        userInfo.setLastName("Tester");
        userInfo.setEmail(javaHelpers.getAlphaNumericString(4)+"@gmail.com");
        userInfo.setPhone("9425252525");
        userInfo.setAddress1("A-010 baker street");
        userInfo.setAddress2("near wllmart circle");
        userInfo.setCity("Ahmedabad");
        userInfo.setState("Gujarat");
        userInfo.setZip("1044");
        userInfo.setCountry("India");
        userInfo.setLanguage("english");
        userInfo.setAnimal("CATS");
        return userInfo;
    }
    public UserInformation loginData(){
        userInfo.setUserId("Tester007");
        userInfo.setNewPassword("Tester@12345");
        return userInfo;
    }
    public UserInformation paymentData(){
        userInfo.setCardType("MasterCard");
        userInfo.setCardNumber("444 5555 7777 3333");
        userInfo.setExpiryDate("08/2023");
        return userInfo;
    }

}
