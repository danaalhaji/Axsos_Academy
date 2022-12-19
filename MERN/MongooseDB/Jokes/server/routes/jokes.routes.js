const JokesController = require("../controllers/jokes.controllers");

module.exports = app => {
    app.get("/api/jokes/", JokesController.findAllJokes);
    app.get("/api/jokes/:id", JokesController.findOneSingleJoke);
    app.post("/api/jokes/new", JokesController.createNewJoke);
    app.get("/api/joke/random", JokesController.findRandomJoke);
};