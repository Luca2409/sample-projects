class Meteorological{

    constructor(temperature, humidity, airPressure, uvIndex, windSpeed){
        this.temperature = temperature;
        this.humidity = humidity;
        this.airPressure = airPressure;
        this.uvIndex = uvIndex;
        this.windSpeed = windSpeed;
    }

    toJson() {

        return {
            temperature: this.temperature,
            humidity: this.humidity,
            airPressure: this.airPressure,
            uvIndex: this.uvIndex,
            windSpeed: this.windSpeed
        };
    }
}

module.exports = Meteorological;