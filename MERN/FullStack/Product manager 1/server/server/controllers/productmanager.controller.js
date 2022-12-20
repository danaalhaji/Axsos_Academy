const Products = require("../models/productmanager.model");

module.exports.findAllProducts = (req, res)=>{
    Products.find({})
    .then(pro => res.json(pro))
    .catch(err => res.json(err))
    };

module.exports.findOneProduct = (req,res)=>{
    Products.findOne({ _id: req.params.id })
		.then(oneSingleProduct => res.json({ product: oneSingleProduct }))
		.catch(err => res.json({ message: "Something went wrong", error: err }));
    };

module.exports.createNewProduct = (req, res) => {
    const { title, price , description } = req.body;
    Products.create({
        title,
        price,
        description
    })
        .then(product =>res.json(product))
        .catch(err =>res.json(err));
    }

    module.exports.updateExistingProduct =(req , res) =>{
        Products.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true })
        .then(updatedProduct => res.json({ product: updatedProduct }))
        .catch(err => res.json({ message: "Something went wrong", error: err }));
    };