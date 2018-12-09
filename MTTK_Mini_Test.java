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

  public static boolean testMTTK_Login_StartValues() {
    MTTK_Login login = new MTTK_Login();
    return login.tempUsername.equals("") && login.usernameIsValid == false;
  }

  public static boolean testInValidUsernameIncheckUsername() {
    MTTK_Login login = new MTTK_Login();
    MTTK_Users.setStateEmptyUsersList();
    return false == login.checkUsername("abc");
  }

  public static boolean testValidUsernameIncheckUsername() {
    MTTK_Login login = new MTTK_Login();
    MTTK_Users.setStateEmptyUsersList();
    MTTK_Create create = new MTTK_Create();
    create.tryUsername("abc");
    create.tryPassword("123");
    create.tryCreate();
    return true == login.checkUsername("abc");
  }

  public static boolean testVariablesAfterUsingInValidUsernameInCheckUsername() {
    MTTK_Login login = new MTTK_Login();
    MTTK_Users.setStateEmptyUsersList();
    login.checkUsername("abc");
    return (login.tempUsername == "" && !login.usernameIsValid);
  }

  public static boolean testVariablesAfterUsingValidUsernameInCheckUsername() {
    MTTK_Login login = new MTTK_Login();
    MTTK_Users.setStateEmptyUsersList();
    MTTK_Create create = new MTTK_Create();
    create.tryUsername("abc");
    create.tryPassword("123");
    create.tryCreate();
    login.checkUsername("abc");
    return (login.tempUsername == "abc" && login.usernameIsValid);
  }

  public static boolean testCheckPasswordAfterUsingInvalidUsernameInCheckUsername() {
    MTTK_Login login = new MTTK_Login();
    MTTK_Users.setStateEmptyUsersList();
    login.checkUsername("abc");
    return (false == login.checkPassword("123"));
  }

  public static boolean testCheckPasswordAfterUsingCorrectPasswordInCheckUsername() {
    MTTK_Login login = new MTTK_Login();
    MTTK_Users.setStateEmptyUsersList();
    MTTK_Create create = new MTTK_Create();
    create.tryUsername("abc");
    create.tryPassword("123");
    create.tryCreate();
    login.checkUsername("abc");
    return (true == login.checkPassword("123"));
  }

  public static boolean testCheckPasswordAfterUsingIncorrectPasswordInCheckUsername() {
    MTTK_Login login = new MTTK_Login();
    MTTK_Users.setStateEmptyUsersList();
    MTTK_Create create = new MTTK_Create();
    create.tryUsername("abc");
    create.tryPassword("123");
    create.tryCreate();
    login.checkUsername("abc");
    return (false == login.checkPassword("321"));
  }

  public static boolean testAddMTTK_User() {
    MTTK_Users.setStateEmptyUsersList();
    MTTK_Users.addMTTK_User("abc","123");
    return (MTTK_Users.usersList.size() == 1);
  }

  public static boolean testSetStateEmptyUsersList() {
    MTTK_Users.addMTTK_User("abc","123");
    MTTK_Users.setStateEmptyUsersList();
    return (MTTK_Users.usersList.size() == 0);
  }

  public static boolean testIndexOfInvalidUsernameWhenUsersListIsEmtpy() {
    MTTK_Users.setStateEmptyUsersList();
    return 0 == MTTK_Users.indexOfUser("abc");
  }

  public static boolean testIndexOfInvalidUsernameWhenUsersListIsNonEmpty() {
    MTTK_Users.setStateEmptyUsersList();
    MTTK_Users.addMTTK_User("abc","123");
    return 1 == MTTK_Users.indexOfUser("cab");
  }

  public static boolean testIndexOfValidUsername() {
    MTTK_Users.setStateEmptyUsersList();
    MTTK_Users.addMTTK_User("abc","123");
    MTTK_Users.addMTTK_User("bca","123");
    MTTK_Users.addMTTK_User("cab","123");
    return 1 == MTTK_Users.indexOfUser("bca");
  }

  public static boolean testPasswordOfUserWhenUsernameIsValid() {
    MTTK_Users.setStateEmptyUsersList();
    MTTK_Users.addMTTK_User("abc","123");
    MTTK_Users.addMTTK_User("bca","123");
    MTTK_Users.addMTTK_User("cab","123");
    return "123" == MTTK_Users.passwordOfUser("bca");
  }

  public static boolean testPasswordOfUserWhenUsernameIsInValidWhenUsersListIsEmpty() {
    MTTK_Users.setStateEmptyUsersList();
    return "-1" == MTTK_Users.passwordOfUser("abc");
  }

  public static boolean testPasswordOfUserWhenUsernameIsInValidWhenUsersListIsNonEmpty() {
    MTTK_Users.setStateEmptyUsersList();
    MTTK_Users.addMTTK_User("abc","123");
    MTTK_Users.addMTTK_User("bca","123");
    return "-1" == MTTK_Users.passwordOfUser("cab");
  }

  public static void main(String[] args) {
    System.out.println("\nTest MTTK_Users:");

    if (testAddMTTK_User()){
      System.out.println("PASSED" + ": testAddMTTK_User()");
    } else {
      System.out.println("FAILED" + ": testAddMTTK_User()");
    }

    if (testSetStateEmptyUsersList()){
      System.out.println("PASSED" + ": testSetStateEmptyUsersList()");
    } else {
      System.out.println("FAILED" + ": testSetStateEmptyUsersList()");
    }

    if (testIndexOfInvalidUsernameWhenUsersListIsEmtpy()){
      System.out.println("PASSED" + ": testIndexOfInvalidUsernameWhenUsersListIsEmtpy()");
    } else {
      System.out.println("FAILED" + ": testIndexOfInvalidUsernameWhenUsersListIsEmtpy()");
    }

    if (testIndexOfInvalidUsernameWhenUsersListIsNonEmpty()){
      System.out.println("PASSED" + ": testIndexOfInvalidUsernameWhenUsersListIsNonEmpty()");
    } else {
      System.out.println("FAILED" + ": testIndexOfInvalidUsernameWhenUsersListIsNonEmpty()");
    }

    if (testIndexOfValidUsername()){
      System.out.println("PASSED" + ": testIndexOfValidUsername()");
    } else {
      System.out.println("FAILED" + ": testIndexOfValidUsername()");
    }

    if (testPasswordOfUserWhenUsernameIsValid()){
      System.out.println("PASSED" + ": testPasswordOfUserWhenUsernameIsValid()");
    } else {
      System.out.println("FAILED" + ": testPasswordOfUserWhenUsernameIsValid()");
    }

    if (testPasswordOfUserWhenUsernameIsInValidWhenUsersListIsEmpty()){
      System.out.println("PASSED" + ": testPasswordOfUserWhenUsernameIsInValidWhenUsersListIsEmpty()");
    } else {
      System.out.println("FAILED" + ": testPasswordOfUserWhenUsernameIsInValidWhenUsersListIsEmpty()");
    }

    if (testPasswordOfUserWhenUsernameIsInValidWhenUsersListIsNonEmpty()){
      System.out.println("PASSED" + ": testPasswordOfUserWhenUsernameIsInValidWhenUsersListIsNonEmpty()");
    } else {
      System.out.println("FAILED" + ": testPasswordOfUserWhenUsernameIsInValidWhenUsersListIsNonEmpty()");
    }

    System.out.println("\nTest MTTK_Login:");

    if (testCheckPasswordAfterUsingIncorrectPasswordInCheckUsername()){
      System.out.println("PASSED" + ": testCheckPasswordAfterUsingIncorrectPasswordInCheckUsername()");
    } else {
      System.out.println("FAILED" + ": testCheckPasswordAfterUsingIncorrectPasswordInCheckUsername()");
    }

    if (testCheckPasswordAfterUsingCorrectPasswordInCheckUsername()){
      System.out.println("PASSED" + ": testCheckPasswordAfterUsingCorrectPasswordInCheckUsername()");
    } else {
      System.out.println("FAILED" + ": testCheckPasswordAfterUsingCorrectPasswordInCheckUsername()");
    }

    if (testCheckPasswordAfterUsingInvalidUsernameInCheckUsername()){
      System.out.println("PASSED" + ": testCheckPasswordAfterUsingInvalidUsernameInCheckUsername())");
    } else {
      System.out.println("FAILED" + ": testCheckPasswordAfterUsingInvalidUsernameInCheckUsername()");
    }

    if (testVariablesAfterUsingInValidUsernameInCheckUsername()){
      System.out.println("PASSED" + ": testVariablesAfterUsingInValidUsernameInCheckUsername()");
    } else {
      System.out.println("FAILED" + ": testVariablesAfterUsingInValidUsernameInCheckUsername()");
    }

    if (testVariablesAfterUsingValidUsernameInCheckUsername()){
      System.out.println("PASSED" + ": testVariablesAfterUsingValidUsernameInCheckUsername()");
    } else {
      System.out.println("FAILED" + ": testVariablesAfterUsingValidUsernameInCheckUsername()");
    }

    if (testValidUsernameIncheckUsername()){
      System.out.println("PASSED" + ": testValidUsernameIncheckUsername()");
    } else {
      System.out.println("FAILED" + ": testValidUsernameIncheckUsername()");
    }

    if (testInValidUsernameIncheckUsername()){
      System.out.println("PASSED" + ": testInValidUsernameIncheckUsername()");
    } else {
      System.out.println("FAILED" + ": testInValidUsernameIncheckUsername()");
    }

      if (testMTTK_Login_StartValues()){
        System.out.println("PASSED" + ": testMTTK_Login_StartValues()");
      } else {
        System.out.println("FAILED" + ": testMTTK_Login_StartValues()");
      }

    System.out.println("\nTest MTTK_Create:");
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
