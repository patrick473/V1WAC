
let    time = new Date().getTime();
let expireDate =new Date().getTime() + 600000;

$(document).ready(function() {
    initPage();
});

function initPage() {
    $.get("http://ip-api.com/json", (data) => {

        $("#as").text(data.as);
        $("#city").text(data.city);
        $("#country").text(data.country);
        $("#countryCode").text(data.countryCode);
        $("#isp").text(data.isp);
        $("#lat").text(data.lat);
        $("#lon").text(data.lon);
        $("#org").text(data.org);
        $("#query").text(data.query);
        $("#region").text(data.region);
        $("#regionName").text(data.regionName);
        $("#status").text(data.status);
        $("#timezone").text(data.timezone);
        $("#zip").text(data.zip);
        lat = data.lat;
        long = data.lon;
        city = data.city;
        $("#countryListTable").append('<tr data-capital="' + data.city + '" data-code="' + data.countryCode + '" data-lat="' + data.lat + '" class="countryItem" data-lon="' + data.lon + '" data-name="' + data.country + '" id="country0"><td class="name">' + data.city + '</td></tr>');
        showWeather(lat, long, city);
        loadCountries();

    });


}

function showWeather(lat, long, city, code) {
    const link = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + long + "&APPID=64ac0146880bdde3f7724f6e2fef2212";
     let getCity = localStorage.getItem(city);
    if (getCity !== null && compareDate(getCity.expire) === true)  {
        $("#cityWeather").text(getCity.name);
        $("#weathermain").text(getCity.weathermain);
        $("#temperature").text(prettify(getCity.temperature));
        $("#humidity").text(getCity.humidity);
        $("#windspeed").text(getCity.windspeed);

    }
    else {
        $.get(link, (data) => {
            console.log(data);

            weather = data.weather[0];
            main = data.main;
            temp = main.temp - 273.15;
            wind = data.wind;

            weathermain = (weather.main);
            console.log(weathermain);
            $("#cityWeather").text(city);
            $("#weathermain").text(weathermain);
            $("#temperature").text(prettify(temp));
            $("#humidity").text(main.humidity);
            $("#windspeed").text(wind.speed);

            let citystorage = {
                name: city,
                weathermain: weathermain,
                temperature: temp,
                humidity: main.humidity,
                windspeed: wind.speed,
                expire: expireDate
            };
            localStorage.setItem(city, JSON.stringify(citystorage));
        });
    }



}

function loadCountries() {

    $.get("http://localhost:4711/firstapp/restservices/countries", (data) => {
        console.log(data);
        $(data).each(function(index) {
            console.log(this.name);
            index += 1;
            $("#countryListTable").append('<tr data-capital="' + this.capital + '" data-code="' + this.countryCode + '" data-lat="' + this.lat + '" class="countryItem" data-lon="' + this.lon + '" data-name="' + this.name + '" id="country' + index + '"><td class="name">' + this.name + '</td></tr>');
            countryid = "#country" + index;
            console.log(countryid);
            console.log($(countryid).data("lat"));
        });
    });

}

$("#countryListTable").delegate('tr', 'click', function() {
    country = $(this).data("name");
    latt = $(this).data("lat");
    lonn = $(this).data("lon");
    code = $(this).data("code");
    capital = $(this).data("capital");

    console.log(latt + " " + lonn + " " + country);
    showWeather(latt, lonn, capital, code);
});

function compareDate(expiredate){
    if (time > expiredate) {
        return true;

    }
    else {
        return false;
    }
}
function prettify(input){
    var output = Math.round(input * 1000000)/1000000;
	return output;
}
