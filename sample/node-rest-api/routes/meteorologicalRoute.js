const express = require('express');
const getMeteorologicalData = require('../controllers/meteorologicalController');

const router = express.Router()

router.get('/meteorological', (req, res) => {
    
    res.json(getMeteorologicalData());
});

module.exports = router;