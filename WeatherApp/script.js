const API_KEY = '0001d13ead381f74b59132c74fecdfba';
const KELVIN= 273.15;

document.getElementById('botonBusqueda').addEventListener('click',async () => {
    let city = document.getElementById('ciudadEntrada').value;
    if(city){
        let response = await fetchDataWeather(city);
        console.log(response);
        showDataWeather(response);
    }
});

async function fetchDataWeather(city){
    let url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}`;
    let data = await fetch(url);
    return data.json();
}

function showDataWeather(dataWeather){
    const divDataWeather = document.getElementById('datosClima');
    divDataWeather.innerHTML = '';
    const cityName = dataWeather.name;
    const temperature = dataWeather.main.temp;
    const humidity = dataWeather.main.humidity;
    const description = dataWeather.weather[0].description;
    const icon = dataWeather.weather[0].icon;
    const country = dataWeather.sys.country;

    const cityTitle = document.createElement('h2');
    cityTitle.textContent = cityName +', ' + country;
    const tempInfo=document.createElement('p');
    tempInfo.textContent = `The temperature is: ${Math.ceil(temperature - KELVIN)} °C`;
    const descriptionInfo=document.createElement('p');
    descriptionInfo.textContent = `Weather description is: ${description}`;
    const humidityInfo=document.createElement('p');
    humidityInfo.textContent = `The humidity is: ${humidity}%`;
    const iconInfo = document.createElement('img');
    iconInfo.src= ` https://openweathermap.org/img/wn/${icon}@2x.png`;

    divDataWeather.appendChild(cityTitle);
    divDataWeather.appendChild(tempInfo);
    divDataWeather.appendChild(humidityInfo);
    divDataWeather.appendChild(iconInfo);
    divDataWeather.appendChild(descriptionInfo);    
}