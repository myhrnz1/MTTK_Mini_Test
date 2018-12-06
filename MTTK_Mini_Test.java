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

  public static void main(String[] args) {
    if (testMTTK_Create_StartValueOftempUsername()){
      System.out.println("PASSED" + ": testMMTK_Create_StartValueOfTempUsernem(): ");
    } else {
      System.out.println("FAILED" + ": testMMTK_Create_StartValueOfTempUsernem(): ");
    }

    if (testMTTK_Create_StartValueOftempPassword()){
      System.out.println("PASSED" + ": testMTTK_Create_StartValueOftempPassword(): ");
    } else {
      System.out.println("FAILED" + ": testMTTK_Create_StartValueOftempPassword(): ");
    }

    if (testMTTK_Create_StartValueOfUsernameIsValid()){
      System.out.println("PASSED" + ": testMTTK_Create_StartValueOfUsernameIsValid(): ");
    } else {
      System.out.println("FAILED" + ": testMTTK_Create_StartValueOfUsernameIsValid(): ");
    }

    if (testMTTK_Create_StartValueOfPasswordIsValid()){
      System.out.println("PASSED" + ": testMTTK_Create_StartValueOfPasswordIsValid(): ");
    } else {
      System.out.println("FAILED" + ": testMTTK_Create_StartValueOfPasswordIsValid(): ");
    }
  }
}
