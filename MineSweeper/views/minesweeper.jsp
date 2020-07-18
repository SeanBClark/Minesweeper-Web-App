<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.Map.Entry" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

    <head>

        <meta charset = "UTF-8">
        <meta name = "viewport" content = "width=device-width, initial-scale = 1, shrink-to-fit = no">
    
        <title>

            User Login

        </title>


        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity = "sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin = "anonymous">
        <link rel = "stylesheet" href ="../css/application.css" type = "text/css"></link>
        <link rel = "stylesheet" href ="../css/minesweeper.css" type = "text/css"></link>

        <script src = "https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity = "sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin = "anonymous"></script>
        <script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity = "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin = "anonymous"></script>
        <script src = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity = "sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin = "anonymous"></script>
        <script type =  'text/javascript' src = '../javascript/minesweeper.js'></script>

    </head>

    <body>

        <div class = 'align-self-center page-div'>

            <jsp:useBean id = "userBean" scope = "session" class = "beans.UserBean" />

            <div>
                            
                <h1><jsp:getProperty property="userName" name="userBean" /> </h1><br /><br />

                <c:forEach var = "item" items = "${sessionScope.userGameList}">
                
                    <span>${item.getGameMode()}</span>
                    <button id = "gridSize" value = "${item.getGridSize()}" hidden></button>
                    <c:set var = "gridSize" value = "${item.getGridSize()}" scope = "session" />
                    <c:set var = "gridSize2" value = "${item.getGridSize()}" scope = "session" />
                    
                
                </c:forEach>

            </div>

            <div class = 'game-panel'>

                <form  method = "post" action = "/c3269995_assignment2/SaveGameServlet?gridSize=${gridSize2}" >

                    <table>

                        <c:set var = "rowStatus" value = "1" />

                        <c:forEach var = "cell" items = "${sessionScope.gameList}" varStatus = "loop">

                            <button type="button" class="btn-ms btn-show" value="${cell.getCellType()}" id = "${cell.getCellNum()}" name = "msBtn">
                            
                                        <span id = "span-${cell.getCellNum()}" class = "span-text">

                                            <c:if test = "${cell.getCellType() == 'Bomb'}">

                                                B

                                            </c:if>
                                        
                                        </span>
                                    
                            
                            </button>
                            <c:if test = "${loop.index == gridSize - 1}">

                                <br />
                                <c:set var = "gridSize" value = "${gridSize + gridSize2}" scope = "session" />

                            </c:if>

                            <input type = "hidden" id = "getValue${cell.getCellNum()}" name = "getValue${cell.getCellNum()}" value = "${cell.getCellType()}" />                   
                            

                        </c:forEach>

                    </table>

                    <button type = "submit" class = "btn btn-primary">Save Game</button>

                </form>
            
            </div>

            <div class = 'win-div'>
            
                <span>You Win!</span>

            </div>

            <div class = 'lose-div'>
            
                <span>Game Over</span>

                <a href = '../views/login.jsp'><button>Return Home</button></a>

            </div>

        </div>

    </body>

</html>