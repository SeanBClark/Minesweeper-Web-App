<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.Map.Entry" %>

<!DOCTYPE html>

    <head>

        <meta charset = "UTF-8">
        <meta name = "viewport" content = "width=device-width, initial-scale = 1, shrink-to-fit = no">
    
        <title>

            User Login

        </title>

        <%-- Stylesheets --%>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity = "sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin = "anonymous">
        <link rel = "stylesheet" href ="../css/application.css" type = "text/css">
        <link rel = "stylesheet" href ="../css/login.css" type = "text/css">


        <%-- Scripts --%>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <%-- <script src = "https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity = "sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin = "anonymous"></script> --%>
        <script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity = "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin = "anonymous"></script>
        <script src = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity = "sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin = "anonymous"></script>
        <script type =  'text/javascript' src = '../javascript/login.js'></script>
    
    </head>

    <body>

        <div class = 'align-self-center page-div'>

            <div class = 'login-form-div'>

                <form method = "post" onSubmit = 'return loginValidation()' action = '/c3269995_assignment2/LoginServlet' >

                    <div class = "form-group">
                    
                        <label for = "inputUserName" class= 'form-label'>User Name </label>

                        <input type = "text" class = "form-control form-input" id = "inputUserName" name = "inputUserName" placeholder = "Enter User Name">

                        <div class = 'alert alert-danger form-input' role = 'alert' id = 'user-name-error'>
                        
                            User Name should only contain letters or numbers

                        </div>
                        <div class = 'alert alert-danger form-input' role = 'alert' id = 'empty-un-error'>
                        
                            Please enter user name

                        </div>
                    
                    </div>

                    <br /><div class="border-top my-3"></div><br />

                    <div class = "form-group">
                    
                        <label for = "inputPassword" class= 'form-label'>Password </label>

                        <input type = "password" class = "form-control form-input" id = "inputPassword" name = "inputPassword" placeholder = "Enter Password">

                        <div class = 'alert alert-danger form-input' role = 'alert' id = 'password-error'>
                        
                            Password should only contain letters or numbers

                        </div>
                        <div class = 'alert alert-danger form-input' role = 'alert' id = 'empty-pw-error'>
                        
                            Please enter password

                        </div>
                    
                    </div>

                    <button type = "submit" class = "btn btn-primary">Submit</button>

                </form>

            </div>

        </div>

    </body>

</html>