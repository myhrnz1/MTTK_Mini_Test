public class MTTK_Mini_Test {

  public static boolean testMTTK_Create_StartValueOftempUsername() {
    MTTK_Create create = new MTTK_Create();
    return create.tempUsername.equals("");
  }

  public static boolean testMTTK_Create_StartValueOftempPassword() {
    MTTK_Create create = new MTTK_Create();
    return create.tempPassword.equals("");
  }

  public static boolean testMTTK_Create_StartValueOfUsernameIsValid() {
    MTTK_Create create = new MTTK_Create();
    return create.usernameIsValid == false;
  }

  public static boolean testMTTK_Create_StartValueOfPasswordIsValid() {
    MTTK_Create create = new MTTK_Create();
    return create.passwordIsValid == false;
  }

  public static boolean testValidUsernameInTryUsername() {
    MTTK_Create create = new MTTK_Create();
    return true == create.tryUsername("abc");
  }

  public static boolean testInValidUsernameInTryUsername() {
    MTTK_Create create = new MTTK_Create();
    MTTK_Users.addMTTK_User("abc","123");
    return false == create.tryUsername("abc");
  }

  public static boolean testVariablesAfterUsingValidUsernameInTryUsername() {
    MTTK_Create create = new MTTK_Create();
    MTTK_Users.setStateEmptyUsersList();
    create.tryUsername("abc");
    return (create.tempUsername == "abc" && create.usernameIsValid == true);
  }

  public static boolean testVariablesAfterUsingInValidUsernameInTryUsername() {
    MTTK_Create create = new MTTK_Create();
    MTTK_Users.addMTTK_User("abc","123");
    create.tryUsername("abc");
    return (create.tempUsername == "" && create.usernameIsValid == false);
  }

  public static boolean testTryCreateReturnsTrueWhenValidVariables() {
    MTTK_Create create = new MTTK_Create();
    create.tempUsername = "cab";
    create.tempPassword = "123";
    create.usernameIsValid = true;
    create.passwordIsValid = true;
    return (create.tryCreate() == true);
  }

  public static boolean testTryCreateAddsMTTK_UsersToUserList() {
    MTTK_Create create = new MTTK_Create();
    create.tempUsername = "abc";
    create.tempPassword = "123";
    create.usernameIsValid = true;
    create.passwordIsValid = true;
    create.tryCreate();
    return (MTTK_Users.usersList.get(0).username == "abc" &&
            MTTK_Users.usersList.get(0).password == "123");
  }

  public static void main(String[] args) {
    if (testMTTK_Create_StartValueOftempUsername()){
      System.out.println("PASSED" + ": testMMTK_Create_StartValueOfTempUsernem()");
    } else {
      System.out.println("FAILED" + ": testMMTK_Create_StartValueOfTempUsernem()");
    }

    if (testMTTK_Create_StartValueOftempPassword()){
      System.out.println("PASSED" + ": testMTTK_Create_StartValueOftempPassword()");
    } else {
      System.out.println("FAILED" + ": testMTTK_Create_StartValueOftempPassword()");
    }

    if (testMTTK_Create_StartValueOfUsernameIsValid()){
      System.out.println("PASSED" + ": testMTTK_Create_StartValueOfUsernameIsValid()");
    } else {
      System.out.println("FAILED" + ": testMTTK_Create_StartValueOfUsernameIsValid()");
    }

    if (testMTTK_Create_StartValueOfPasswordIsValid()){
      System.out.println("PASSED" + ": testMTTK_Create_StartValueOfPasswordIsValid()");
    } else {
      System.out.println("FAILED" + ": testMTTK_Create_StartValueOfPasswordIsValid()");
    }

    if (testValidUsernameInTryUsername()){
      System.out.println("PASSED" + ": testValidUsernameInTryUsername()");
    } else {
      System.out.println("FAILED" + ": testValidUsernameInTryUsername()");
    }

    if (testInValidUsernameInTryUsername()){
      System.out.println("PASSED" + ": testInValidUsernameInTryUsername()");
    } else {
      System.out.println("FAILED" + ": testInValidUsernameInTryUsername()");
    }

    if (testVariablesAfterUsingValidUsernameInTryUsername()){
      System.out.println("PASSED" + ": testVariablesAfterUsingValidUsernameInTryUsername()");
    } else {
      System.out.println("FAILED" + ": testVariablesAfterUsingValidUsernameInTryUsername()");
    }

    if (testVariablesAfterUsingInValidUsernameInTryUsername()){
      System.out.println("PASSED" + ": testVariablesAfterUsingInValidUsernameInTryUsername()");
    } else {
      System.out.println("FAILED" + ": testVariablesAfterUsingInValidUsernameInTryUsername()");
    }

    if (testTryCreateReturnsTrueWhenValidVariables()){
      System.out.println("PASSED" + ": testTryCreateReturnsTrueWhenValidVariables()");
    } else {
      System.out.println("FAILED" + ": testTryCreateReturnsTrueWhenValidVariables()");
    }

    if (testTryCreateReturnsTrueWhenValidVariables()){
      System.out.println("PASSED" + ": testTryCreateAddsMTTK_UsersToUserList()");
    } else {
      System.out.println("FAILED" + ": testTryCreateAddsMTTK_UsersToUserList()");
    }
  }
}
