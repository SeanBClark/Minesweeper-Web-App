$(document).ready(function ()
{

    $("#user-name-error").hide();
    $("#password-error").hide();
    $('#empty-pw-error').hide();
    $('#empty-un-error').hide();

});

function loginValidation() 
{

    let userName = document.getElementById('inputUserName');
    let password = document.getElementById('inputPassword');

    if (userName.value === "" || userName.value === null)
    {

        $('#empty-un-error').show();
        return false;

    }
    if (letterNumValidator(userName.value) === false)
    {

        $("#user-name-error").show();
        return false;

    }

    if (password.value === "" || password.value === null)
    {

        $('#empty-pw-error').show();
        return false;

    }
    if (letterNumValidator(password.value) === false)
    {

        $("#password-error").show();
        return false;

    }

}

function letterNumValidator(param)
{

    var letterNumber = /^[0-9a-zA-Z]+$/;
    return letterNumber.test(param);

}

// function isEmail(email) {
//     var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
//     return regex.test(email);
//   }