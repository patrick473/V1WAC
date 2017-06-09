
$("#inputfield").keyup(function(){
   storage = $(this).val();
   localStorage.setItem('storage',storage);

    console.log(localStorage.getItem('storage'));
    });


$("#result").ready( () =>{


 $("#resultText").text(localStorage.getItem('storage'));


});
