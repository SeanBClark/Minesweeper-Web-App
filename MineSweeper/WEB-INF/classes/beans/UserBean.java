package beans;

public class UserBean implements java.io.Serializable
{

    private String userName;
    private String password;

    public UserBean(){}

    public UserBean(String userName, String password)
    {

        this.userName = userName;
        this.password = password;

    }

    public void setUserName(String param) 
    {

        this.userName = param;

    }

    public String getUserName()
    {

        return userName;

    }

    public void setPassword(String param)
    {

        this.password = param;

    }

    public String getPassword()
    {

        return password;

    }



}