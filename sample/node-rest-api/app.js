const express = require('express');
const meteorologicalRoute = require('./routes/meteorologicalRoute');

const app = express();
const port = 3000;

app.use('/test', meteorologicalRoute);


app.listen(port, () => {
    console.log(`App listens on port ${port}`)
});