class Problem1 extends ConsoleProgram {

  /**
  * A program Problem1.java that takes in the first and last name of the user, their student number and username, and determines if the username is valid and a new password.
  * @author: Simon Tse
  */
  
  public void run() {
    // Declare variables
    String strUserFirst;
    String strUserLast;
    String strUserNum;
    String strUserUser;

    // Getting Variables
    System.out.println("**** Student Account Registration ****");
    strUserFirst = readLine("Enter your first name: ");
    strUserLast = readLine("Enter your last name: ");
    strUserNum = readLine("Enter your student number: ");
    strUserUser = readLine("Enter a new username: ");

    // Output Results
    System.out.println("Valid username: " + validateUsername(strUserUser));
    System.out.println("Your password is: " + createPassword(strUserFirst, strUserLast, strUserNum));    
  }
  /**
   * Returns true or false if depending of the user's inputted username meets the required conditions
   * @param strUserName The username the user inputs 
   */
  public boolean validateUsername(String strUserName){
    if(strUserName.length() > 7){
      return true;
    }
    int intNumNum = 0;
    for(int i = 0; i < strUserName.length(); i++){
      if( Character.isDigit(strUserName.charAt(i))){
        intNumNum++;
      }
      if(Character.isLetter(strUserName.charAt(i)) == true){
        return true;
      }
      else{
        return false;
      }
    }
    if (intNumNum > 0){
      return true;
    }
    return false;
  }
/**
 *  A method that takes the student's number and their first and last name to create and return a passsword
 * @param strFirst The student's first name
 * @param strLast The student's last name
 * @param strStudentNum The student's student number
 */
  public String createPassword(String strFirst, String strLast, String strStudentNum){
    String strPassword = "";
    String strError = "Exception in the thread main java.lang.IllegalArguementException: incorrect parameters(s)";
    if(strLast.length() < 4){
      strPassword = strLast.toLowerCase() + Character.toUpperCase(strFirst.charAt(0)) + strStudentNum.substring(3,6);
    }
    else {
      strPassword = strLast.substring(0,4).toLowerCase() + Character.toUpperCase(strFirst.charAt(0)) + strStudentNum.substring(3,6);
    }
    if(strFirst.length() == 0 || strLast.length() == 0 || strStudentNum.length() < 9 || strStudentNum.length() > 9){
      return strError;
    }
   return strPassword;
  }
}