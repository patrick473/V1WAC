// TIMER
function getText(){
    a = document.getElementById("text").value;
    console.log(a);


}


$(document).ready( function() {

setInterval(function() {
    getText();
}, 5000);
});
