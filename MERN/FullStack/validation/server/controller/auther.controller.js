const Auther = require("../model/auther.model");

module.exports.findAllAuthers = (req, res)=>{
    Auther.find({})
    .then(pro => res.json(pro))
    .catch(err => res.json(err))
    };

module.exports.findOneAuther = (req,res)=>{
    Auther.findOne({ _id: req.params.id })
        .then(oneSingleAuther => res.json({ auther: oneSingleAuther }))
        .catch(err => res.json({ message: "Something went wrong", error: err }));
    };

module.exports.createNewProduct = (req, res) => {
        const { name } = req.body;
Auther.create({
    name,
})
.then(auther =>res.json(auther))
.catch(err =>res.status(400).json(err));
}

module.exports.deleteAuther =(req, res) =>{
    Auther.deleteOne({ _id: req.params.id })
        .then(deleteConfirmation => res.json(deleteConfirmation))
        .catch(err => res.json(err))
}