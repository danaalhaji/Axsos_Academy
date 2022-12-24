const mongoose = require("mongoose");

var enu ={
    values:["Goalkeeper", "Defenders", "Midfielders" , "Forwards"],
    message:' the postion should be one of the following : "Goalkeeper", "Defenders", "Midfielders" , "Forwards"'

}

const playerSchema = new mongoose.Schema({
    name:{
        type: String,
        required: [
            true,
            "Name is required"
        ],
        minlength:[2 , "The minimum character is 2!"]
    },
    position:{
        type:String,
        enum:enu
    },
    g1Status:{
        type:Number,
        enum:[0,1,2],
        default:0
    },
    g1Color:{
        type:String,
        enum:["white", "red" ,"green"],
        default:"white"
    }
    ,
    g2Status:{
        type:Number,
        enum:[0,1,2],
        default: 0
    },
    g2Color:{
        type:String,
        enum:["white", "red" ,"green"],
        default:"white"
    },
    g3Status:{
        type:Number,
        enum:[0,1,2],
        default:0
    },
    g3Color:{
        type:String,
        enum:["white", "red" ,"green"],
        default:"white"
    },
    }

, { timestamps: true })

module.exports = mongoose.model("player",playerSchema);