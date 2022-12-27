const Player = require("../model/player.model");

module.exports.findAllPlayers = (req, res)=>{
    Player.find().sort({name:1})
    .then(pro => res.json(pro))
    .catch(err => res.json(err))
    };

module.exports.findOnePlayer = (req,res)=>{
    Player.findOne({ _id: req.params.id })
        .then(oneSingleAuther => res.json({ auther: oneSingleAuther }))
        .catch(err => res.json({ message: "Something went wrong", error: err }));
    };

module.exports.createNewPlayer = (req, res) => {
    const { name , position} = req.body;
    Player.create({
    name,
    position
})
.then(auther =>res.json(auther))
.catch(err =>res.status(400).json(err));
}

module.exports.deletePlayer = (req, res) =>{
    Player.deleteOne({ _id: req.params.id })
        .then(deleteConfirmation => res.json(deleteConfirmation))
        .catch(err => res.json(err))
}

module.exports.updateOnePlayer = (req, res) =>{
    Player.findOneAndUpdate({_id: req.params.id}, req.body, {new:true, runValidators: true })
    .then(player =>res.json(player))
    .catch(err =>res.status(400).json(err));
    }
