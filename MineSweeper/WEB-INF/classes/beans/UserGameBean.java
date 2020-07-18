package beans;

public class UserGameBean 
{

    private Integer gridSize;
    private Integer mineID;
    private Integer userID;
    private String gameMode;

    public UserGameBean() {
    }
    public UserGameBean(Integer mineID, Integer userID, String gameMode, Integer gridSize) 
    {

        this.mineID = mineID;
        this.userID = userID;
        this.gameMode = gameMode;
        this.gridSize = gridSize;
        
    }

    public void setMineID(Integer param) 
    {

        this.mineID = param;

    }

    public Integer getMineID() 
    {

        return mineID;

    }

    public void setUserID(Integer param) 
    {

        this.userID = param;

    }

    public Integer getUserID() 
    {

        return userID;

    }

    public void setGameMode(String param) 
    {

        this.gameMode = param;

    }

    public String getGameMode() 
    {

        return gameMode;

    }

    public void setGridSize(Integer param) 
    {

        this.gridSize = param;

    }

    public Integer getGridSize() 
    {

        return gridSize;

    }

}