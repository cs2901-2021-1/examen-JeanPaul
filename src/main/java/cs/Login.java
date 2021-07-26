package cs;

public final class Login {
    private static Login login;


    public Login() {    // is a singleton constructor

    }

    public static Login getInstance(){
        if(login == null){
            login = new Login();
        }
        return login;
    }


    public boolean login(String username, String password){

        if(username.length() != password.length()) return false;

        for(var i = 0; i < username.length(); i++){
            if(username.charAt(i) != password.charAt(username.length() - 1 - i))
                return false;
        }
        return true;
    }


}
