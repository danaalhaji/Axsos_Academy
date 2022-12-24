const PlayerController = require('../controller/player.controller');

module.exports = function(app){
        app.get('/api/player', PlayerController.findAllPlayers);
        app.get('/api/player/:id', PlayerController.findOnePlayer);
        app.post('/api/player', PlayerController.createNewPlayer);
        app.delete('/api/player/:id', PlayerController.deletePlayer);
        app.put('/api/player/:id', PlayerController.updateOnePlayer);
    }
    