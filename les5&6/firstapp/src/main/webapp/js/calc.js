
let previous;
let operator;
let display = "";
let current = "";
let outcome;

$("#btn_7").mousedown( () =>{
    display += "7";
    current += "7";
    updatedisplay();
});

$("#btn_8").mousedown( () =>{
    display += "8";
    current += "8";
    updatedisplay();
});

$("#btn_9").mousedown( () =>{
    display += "9";
    current += "9";
    updatedisplay();
});



$("#btn_4").mousedown( () =>{
        display += "4";
        current += "4";
        updatedisplay();
});
$("#btn_5").mousedown( () =>{
        display += "5";
        current += "5";
        updatedisplay();
});
$("#btn_6").mousedown( () =>{
        display += "6";
        current += "6";
        updatedisplay();
});



$("#btn_1").mousedown( () =>{
        display += "1";
        current += "1";
        updatedisplay();
});
$("#btn_2").mousedown( () =>{
        display += "2";
        current += "2";
        updatedisplay();
});
$("#btn_3").mousedown( () =>{
        display += "3";
        current += "3";
        updatedisplay();
});

$("#btn_div").mousedown(()=>{
    previous = parseInt(current);
    current = "";
    operator = "/";
    display += " / ";
    updatedisplay();
});

$("#btn_prod").mousedown(()=>{
    previous = parseInt(display);
    current = "";
    operator = "*";
    display += " * ";
    updatedisplay();
});
$("#btn_min").mousedown(()=>{
    previous = parseInt(display);
    current = "";
    operator = "-";
    display += " - ";
    updatedisplay();
});
$("#btn_plus").mousedown(()=>{
    previous = parseInt(display);
    current = "";
    operator = "+";
    display += " + ";
    updatedisplay();
});

$("#btn_clear").mousedown(()=>{
    clear();
    updatedisplay();
});

$("#btn_eq").mousedown(()=>{
   a =parseInt(previous);
   b =parseInt(current);
   console.log(a);
   console.log(b);
    if(operator == "+"){
                outcome = a + b;
                console.log(outcome);

            }
        else if(operator == "-"){
                outcome = a - b;
            }
        else if(operator == "*"){
                outcome = a * b;
            }
            else if(operator == "/"){
                 outcome = a / b;
            }

    $("#display").text(outcome.toString());

});

function updatedisplay(){
    $("#display").text(display);
}

function clear(){
    previous = "";
    display = "";
    operator = "";
    current = "";
    $("#display").text("0");
}
