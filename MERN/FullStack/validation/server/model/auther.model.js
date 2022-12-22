const mongoose = require("mongoose");

const autherSchema = new mongoose.Schema({
    name:{
        type: String,
        required: [
            true,
            "Name is required"
        ]
    }
}, { timestamps: true })

module.exports = mongoose.model("Auther",autherSchema);