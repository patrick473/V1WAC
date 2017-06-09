$("#loginButton").click(function(event) {
  var data = $("#loginform").serialize();

  $.post("http://localhost:4711/firstapp/restservices/authentication", data, function(response) {
    window.sessionStorage.setItem("sessionToken", response);
    window.location.replace("manageCountries.html");

  }).fail(function(jqXHR, textStatus, errorThrown) {
    console.log(textStatus);
    console.log(errorThrown);
  });
});
