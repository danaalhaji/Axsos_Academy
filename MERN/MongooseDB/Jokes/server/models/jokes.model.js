const mongoose = require("mongoose");

const JokesSchema = new mongoose.Schema(
    {
        setUp :{
            type: String,
            required:[true,"the set up required"],
            minlength :[6, "minimun charactrs is 6!"],
        },  
        punchLine :{
            type:String,
            required :[true, "the pucnline is required"],
            minlength :[true , "the minimum number for characters is 10!"]
    },
},{timestamps:true});

const Joke = mongoose.model("Joke" , JokesSchema);
module.exports = Joke;