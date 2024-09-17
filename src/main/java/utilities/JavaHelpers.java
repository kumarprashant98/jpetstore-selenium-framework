package utilities;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JavaHelpers {

    //Time-stamps

    /**
     * Get Property value
     *
     * @param propertyFile property file name
     * @param propertyName property name
     * @return property value
     */
    public static String getPropertyValue(String propertyFile, String propertyName) {
        Properties prop = accessPropertiesFile(propertyFile);
        return prop.getProperty(propertyName);
    }

    /**
     * Access property file
     *
     * @param propertyFile property file name
     * @return Properties object
     */
    public static Properties accessPropertiesFile(String propertyFile) {
        Properties prop = new Properties();
        // try retrieve data from file
        try {
            prop.load(new FileInputStream(propertyFile));
        }
        // catch exception in case properties file does not exist
        catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


    //Java Methods

    /**
     * Json deserialization to Java Object
     *
     * @param json string json
     * @param dto  Class Object
     * @return Class Object equivalent to json file
     */
    /*public static <T> T jsonDeserialization(String json, Class<T> dto) {
        return new Gson().fromJson(json, dto);
    }*/


    //Data Reader

    /**
     * Set system variable - set it from system variable first, if not found -set it from properties file
     *
     * @param name                 variable name
     * @param propertyFileLocation properties file location
     * @return variable value
     */
    public static String setSystemVariable(String propertyFileLocation, String name) {
        //Reading from system properties.
        String variable = System.getProperty(name);

        //if not specified via command line, take it from constants.properties file
        if (variable == null || variable.isEmpty()) {
            variable = JavaHelpers.getPropertyValue(propertyFileLocation, name);
        }
        return variable;
    }

    /**
     * Json To String
     *
     * @param filePath json file path
     * @return string
     * @throws IOException    exception
     * @throws ParseException exception
     */
    /*public static String jsonToString(String filePath) throws IOException, ParseException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filePath));
        return obj.toString();
    }*/

    /**
     * Get current time-stamp in given format
     *
     * @param format e.g. "yyyy MMM dd", 'yyyyMMdd_HHmmss' etc.
     * @return String timestamp
     */
    public String getTimeStamp(String format) {
        /*
         * Example format are :
         *
         * "yyyy MMM dd" for "2013 Nov 28"
         *
         * "yyyyMMdd_HHmmss" for "20130131000000"
         *
         * "yyyy MMM dd HH:mm:ss" for "2013 Jan 31 00:00:00"
         *
         * "dd MMM yyyy" for "28 Nov 2017"
         */
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }


    //Folder Operations

    /**
     * Get current time-stamp in "_yyyyMMdd_HHmmss" format
     *
     * @return timestamp
     */
    public String timeStamp() {
        return getTimeStamp("_yyyyMMdd_HHmmss");
    }

    //Reading system properties

    /**
     * Get method name where this method is called
     *
     * @return String method name
     */
    public String getMethodName() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }

    //JSON

    /**
     * Delete all files from given folder
     *
     * @param folderPath folder path
     */
    public void deleteAllFilesFromFolder(String folderPath) {
        File dir = new File(folderPath);
        if (!dir.isDirectory()) {
            return;
        }
        File[] listFiles = dir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    /**
     * Random String
     *
     * @param n n
     * @return string
     */
    public String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Get Random Number
     *
     * @param number number
     * @return randomNumber
     */
    public String getRandomNumber(int number) {

        String Numeric = "0123456789";

        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i < number; i++) {

            int index
                    = (int) (Numeric.length()
                    * Math.random());
            sb.append(Numeric
                    .charAt(index));
        }

        return sb.toString();
    }

    /**
     * Get Random Number Between Rage
     *
     * @param max max
     * @param min min
     * @return randomNumber
     */
    public double getRandomNumberBetweenRage(int max, int min) {
        Random random = new Random();
        return Double.parseDouble(String.format("%.2f", random.nextInt(max - min) + min + random.nextFloat()));
    }

    /**
     * Get Random Number
     *
     * @param maxNumber int
     * @param minNumber int
     * @return randomNumber
     */
    public int getRandomNumber(int maxNumber, int minNumber) {
        double math = Math.floor(Math.random() * ((maxNumber) - minNumber) + minNumber);
        return (int) math;
    }


    /**
     * Random String
     *
     * @param n n
     * @return string
     */
    public String getAlphaString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    public String getDoubleSpaceString(String string, int length) {
        return String.format(string + "%1$" + length + "s" + string);
    }

    public String getSpecialCharacterString(int n) {
        String specialCharacterString = "@$!%*?&+=^#()`~";
        Random randomNumber = new Random();

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {

            int randomNo = randomNumber.nextInt(specialCharacterString.length());
            sb.append(specialCharacterString.charAt(randomNo));

        }
        return sb.toString();
    }

    public String getRandom(int max) {
        return String.valueOf((int) (Math.random() * max) + 1);
    }

    public String getRandomStringFromList(String[] list) {

        // String[] list = {"One", "Two", "Three", "Four", "Five"};
        Random ran = new Random();
        return list[ran.nextInt(list.length)];
    }

    /**
     * Get Capitalize Initial Alphabets
     *
     * @param name name
     * @return capitalize name
     */
    public String getCapitalizeInitialAlphabets(String name) {
        String[] words = name.split("\\s");
        String capitalizeWord = "";
        for (String w : words) {
            String first = w.substring(0, 1);
            String afterFirst = w.substring(1);
            capitalizeWord += first.toUpperCase() + afterFirst + " ";
        }
        return capitalizeWord.trim();
    }

    /**
     * Get User DOB Month In String Format
     *
     * @param month month
     * @throws java.text.ParseException Exception
     */
    public String getUserDOBMonthInStringFormat(String month) throws java.text.ParseException {

        //Get Month number by month name
        Date dateText = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(month);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateText);
        var indexOfMonth = calendar.get(Calendar.MONTH) + 1;

        //format month number
        var numberMonth = String.format("%02d", indexOfMonth);

        var indexOfMonthOne = Integer.parseInt(numberMonth) - 1;
        return new DateFormatSymbols().getMonths()[indexOfMonthOne];
    }

    /**
     * Get Date Time Formatter
     *
     * @param pattern pattern
     * @param date    date
     */
    public String getDateTimeFormatter(String pattern, LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(date);
    }

    /**
     * Get Round Off After Decimal
     *
     * @param value value
     * @return  round of value in decimal
     */
    public Double getRoundOffAfterDecimal(double value) {
        DecimalFormat decimalformat = new DecimalFormat("#.##");
        return Double.valueOf(decimalformat.format(value));
    }

    /**
     * Get Two Decimal Round Off
     *
     * @param value value
     * @return  round of value in decimal
     */
    public Double getTwoDecimalRoundOff(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return Double.valueOf(decimalFormat.format(value));
    }

    /**
     * Get Random String From List
     *
     * @param  list list
     * @return  random string from list
     */
    public String getRandomStringFromList(List<String> list) {
        Random ran = new Random();
        return list.get(ran.nextInt(list.size()));
    }

}
