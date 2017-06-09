
function getText(){
    a = document.getElementById("text").value;
    console.log(a);


}


$(document).ready( function() {
    alert("hi");
setInterval(function() {
    getText();
}, 5000);
});
