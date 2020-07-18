package beans;

// Bean for game state
public class GameBean implements java.io.Serializable 
{

    private Integer gameID;
    private Integer mineID;
    private Integer rowNum;
    private Integer cellNum;
    private String cellType;

    public GameBean(){}

    public GameBean(Integer gameID, Integer mineID, Integer rowNum, Integer cellNum, String cellType) 
    {

        this.gameID = gameID;
        this.mineID = mineID;
        this.rowNum = rowNum;
        this.cellNum = cellNum;
        this.cellType = cellType;

    }

    public void setGameID(Integer param) 
    {

        this.gameID = param;

    }

    public Integer getGameID() 
    {

        return gameID;

    }

    public void setMineID(Integer param) 
    {

        this.mineID = param;

    }

    public Integer getMineID() 
    {

        return mineID;

    }

    public void setRowNum(Integer param) 
    {

        this.rowNum = param;

    }

    public Integer getRowNum() 
    {

        return rowNum;

    }

    public void setCellNum(Integer param) 
    {

        this.cellNum = param;

    }

    public Integer getCellNum() 
    {

        return cellNum;

    }

    public void setCellType(String param) 
    {

        this.cellType = param;

    }

    public String getCellType() 
    {

        return cellType;

    }


}