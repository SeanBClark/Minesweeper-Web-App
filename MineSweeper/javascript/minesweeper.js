// JS/Jquery script for minesweeper.js
var mineCount = 0;

$(document).ready(function () {
    
    $(".win-div").hide();
    $(".lose-div").hide();

    var gridSize = document.getElementById("gridSize").value;
    
    // counts mines to determine when user wins
    for (i = 1; i <= gridSize * gridSize; i++) {

        var currentElement = document.getElementById(i);

        if (currentElement.value === "Bomb"){
            mineCount++;
        }

    }

    console.log(mineCount);
    
    // adds up nearby mines for each button and displays the count
    for (i = 1; i <= gridSize * gridSize; i++) {

        var bombCount = 0;
        var currentElement = document.getElementById(i);
        var nextElement = document.getElementById(i + 1);
        var previousElement = document.getElementById(i - 1);
        var aboveElement = document.getElementById(i - Number(gridSize))
        var belowElement = document.getElementById(i + Number(gridSize));
        var belowLeftElement = document.getElementById(i + Number(gridSize) - 1);
        var belowRightElement = document.getElementById(i + Number(gridSize) + 1);
        var aboveLeftElement = document.getElementById(i - Number(gridSize) - 1);
        var aboveRightElement = document.getElementById(i - Number(gridSize) + 1);

        if ( currentElement.value !== "Bomb" && nextElement !== null 
            && aboveElement !== null 
            && belowLeftElement !== null 
            && belowRightElement !== null 
            && aboveLeftElement !== null 
            && aboveRightElement !== null) 
        {
            if (nextElement.value == "Bomb") {
                bombCount++;
                $("#span-" + i).text(bombCount);
            }
            if (aboveElement.value == "Bomb") {
                bombCount++;
                $("#span-" + i).text(bombCount);
            }
            if (belowLeftElement.value == "Bomb") {
                bombCount++;
                $("#span-" + i).text(bombCount);
            }
            if (belowRightElement.value == "Bomb") {
                bombCount++;
                $("#span-" + i).text(bombCount);
            }
            if (aboveLeftElement.value == "Bomb") {
                bombCount++;
                $("#span-" + i).text(bombCount);
            }
            if (aboveRightElement.value == "Bomb") {
                bombCount++;
                $("#span-" + i).text(bombCount);
            }
            
        }
        if ( currentElement.value !== "Bomb" && previousElement !== null && belowElement !== null) {
            if (previousElement.value == "Bomb") {
                bombCount++;
                $("#span-" + i).text(bombCount);
            }
            if (belowElement.value == "Bomb") {
                bombCount++;
                $("#span-" + i).text(bombCount);
            }
        }        
    }
});
// Handles the right click for mines
$(document).bind("contextmenu", function (event) {

    event.preventDefault();
    if (event.target.value === "Bomb" || event.target.value === "Correct"  || event.target.value === "Empty" || event.target.value === "Wrong"){ 
        $(event.target).addClass("btn-mark");

        var targetID = event.target.id;
        console.log(targetID);

    if (event.target.value === "Bomb" || event.target.value === "Correct") {

        $(event.target).val("Correct");
        mineCount--;
        
        $("#getValue" + targetID).val("Correct");
        console.log($("#getValue" + targetID).val());

        if (mineCount === 0){

            $(".game-panel").hide();
            $(".win-div").show();
        }
        console.log(mineCount);
    }
    else {

        $(event.target).val("Wrong");
    }
    }
});

$(document).bind("click", function (event) {
    
    if (event.target.value === "Bomb") {

        $(".game-panel").hide();
        $(".lose-div").show();

    }

});