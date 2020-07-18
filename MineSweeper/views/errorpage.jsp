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
        <link rel = "stylesheet" href ="../css/errorpage.css" type = "text/css"></link>
        <link rel = "stylesheet" href ="../css/login.css" type = "text/css"></link>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <%-- <script src = 'https://code.jquery.com/jquery-3.2.1.min.js' integrity = 'sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin = 'anonymous'></script> --%>
        <script src = 'https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity = 'sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin = 'anonymous'></script>
        <script src = 'https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity = 'sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin = 'anonymous'></script>
        <script type =  'text/javascript' src = '../javascript/gameload.js'></script>
    
    </head>

    <body>

    <div class = 'page-div '>

        <div class = 'login-form-div'>

            <span class = 'error-message'>Something went wrong</span>

            <br /><br />

            <a href = '../views/login.jsp'><button class = 'btn btn-success  btn-lg'>Return Home</button></a>

        </div>

    </div>

    </body>

</html>