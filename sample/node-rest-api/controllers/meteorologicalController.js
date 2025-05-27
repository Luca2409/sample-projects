const Meteorological = require('../models/meteorological') 

const getMeteorologicalData = () => {

    const test = new Meteorological(20, 80, 23, 23, 4);
    console.log(test);
    return test;
};

module.exports = getMeteorologicalData;