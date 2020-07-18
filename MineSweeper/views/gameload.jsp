<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.Map.Entry" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

    <head>

        <meta charset = 'UTF-8'>
        <meta name = 'viewport' content = 'width=device-width, initial-scale = 1, shrink-to-fit = no'>
    
        <title>

            Load Game

        </title>


        <link rel = 'stylesheet' href = 'https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity = 'sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin = 'anonymous'>
        <link rel = "stylesheet" href ="../css/application.css" type = "text/css"></link>
        <link rel = "stylesheet" href ="../css/gameload.css" type = "text/css"></link>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <%-- <script src = 'https://code.jquery.com/jquery-3.2.1.min.js' integrity = 'sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin = 'anonymous'></script> --%>
        <script src = 'https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity = 'sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin = 'anonymous'></script>
        <script src = 'https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity = 'sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin = 'anonymous'></script>
        <script type =  'text/javascript' src = '../javascript/gameload.js'></script>
    
    </head>

    <body>

    <div class = 'align-self-center page-div'>

        <div class = 'new-load-div'>
            
            <jsp:useBean id = "userBean" scope = "session" class = "beans.UserBean" />

            <div>
                            
                <h1>Welcome <jsp:getProperty property="userName" name="userBean" /> </h1><br /><br />

            </div>

            <button type = 'button' class = 'btn btn-primary  btn-lg' id = 'new-game-btn' onClick = 'newLoadClick()'>New Game</button>

            <div id = 'game-mode-div' class = 'game-mode-div'>

                <button type = 'button' class = 'close close-btn' aria-label = 'Close' onClick = 'closeChoices()'>

                    <span aria-hidden = 'true'>&times;</span>

                </button>

                <form method = "post" action = '/c3269995_assignment2/MinesweeperServlet' >

                    <button type = 'submit' class = 'btn btn-success  btn-lg' name = 'gameModeBtn' value = '10'>Beginner</button>

                    <button type = 'submit' class = 'btn btn-success  btn-lg' name = 'gameModeBtn' value = '15'>Intermediate</button>

                    <button type = 'submit' class = 'btn btn-success  btn-lg' name = 'gameModeBtn' value = '20'>Advanced</button>

                </form>
            
            </div>

            <br /><br />

            <form method = "get" action = '/c3269995_assignment2/GameServlet' >

                <button type = 'submit' class = 'btn btn-primary  btn-lg'>Load Game</button>

            </form>

            

        </div>

    </div>

    </body>

</html>