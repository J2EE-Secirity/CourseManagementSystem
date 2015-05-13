package ua.edu.nuos.jeetraining2011.cms.servlet.admin;

/**
 * Created with IntelliJ IDEA.
 * User: Саша
 * Date: 20.07.12
 * Time: 5:39
 * To change this template use File | Settings | File Templates.
 */

public class UserInfo
{
    String   UserName  = "";
    String  ErrorText  = "";
    boolean  LoginFlag = false;

    public UserInfo()
    {
        ;
    }

    public String GetUser()
    {
        return UserName;
    }

    public void Login(String TheUser)
    {
        LoginFlag = true;
        ErrorText = "";
        UserName = TheUser;
    }

    public void SetError(String TheText)
    {
        ErrorText = TheText;
    }

    public String GetError()
    {
        return ErrorText;
    }

    public String IsLogin()
    {
        if (LoginFlag)
            return "true";
        return "false";
    }

    public void Logout()
    {
        LoginFlag = false;
        UserName = "";
        ErrorText = "";
    }
}
