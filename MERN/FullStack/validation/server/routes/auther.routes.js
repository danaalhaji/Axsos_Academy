const AutherController = require('../controller/auther.controller');

module.exports = function(app){
        app.get('/api/auther', AutherController.findAllAuthers);
        app.get('/api/auther/:id', AutherController.findOneAuther);
        app.post('/api/auther', AutherController.createNewProduct);
        app.delete('/api/auther/:id', AutherController.deleteAuther);
    }
    