const mongoose = require("mongoose");

const JokesSchema = new mongoose.Schema(
    {
        setUp :String,
        punchLine :String
    });

const Jokes = mongoose.model("Jokes" , JokesSchema);
module.exports = Jokes;