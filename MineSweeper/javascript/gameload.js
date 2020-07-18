
$(document).ready(function() {

    $('#game-mode-div').hide();

});

function newLoadClick()
{

    $("#game-mode-div").slideDown(850);
    $("#new-game-btn").removeClass("btn-primary");
    $("#new-game-btn").addClass("btn-secondary");

}

function closeChoices()
{

    $("#game-mode-div").slideUp(850);
    $("#new-game-btn").removeClass("btn-secondary");
    $("#new-game-btn").addClass("btn-primary");

}