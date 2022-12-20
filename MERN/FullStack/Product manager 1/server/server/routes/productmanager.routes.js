const ProductController = require('../controllers/productmanager.controller');
 
module.exports = function(app){
    app.get('/api/products', ProductController.findAllProducts);
    app.get('/api/products/:id', ProductController.findOneProduct);
    app.put('/api/products/:id', ProductController.updateExistingProduct);
    app.post('/api/products', ProductController.createNewProduct);
}
