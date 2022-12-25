import { Link, Router } from '@reach/router'
import React from 'react'
import Main from './Main'
import Create from './Create';

const Home = () => {
  return (
    <div>

    <Link to="/player/list"> Players List </Link>
    <Link to ="/player/create"> Add Player</Link>
    <Router>
        <Main path="/player/list"></Main>
        <Create path="/player/create"></Create>
    </Router>
    </div>
  )
}

export default Home
