import React, { useEffect, useState } from 'react';
import axios from 'axios';
import GameTwo from '../component/GameTwo';
import { Link } from '@reach/router';
import Header from './Header';

const DisplayG2 = () => {
    const [players, setPlayers] = useState(null);
    const [loaded, setLoaded] = useState(false);
    const [player , setPlayer] = useState()

    useEffect(() =>{
        axios.get('http://localhost:8000/api/player')
        .then(res=>{
            setPlayers(res.data);
            setLoaded(true);
        })
        .catch(err => console.error(err.response.data));
        console.log("hi")
    },[]);


    const update =(id, g2Status)=>{
        axios.put('http://localhost:8000/api/player/' + id, {
            g2Status,
        })
            .then(res => {setPlayers([...players,res.data])})
            .catch(err => console.error(err));
    }
  return (
    <div>
        <Header></Header>
        <Link to="/player/status">Game 1</Link>
        <Link to="/player/game2">Game 2</Link>
        <h1>Game2</h1>
        {loaded &&
      <GameTwo Players={players} update={update}></GameTwo>
    }
    </div>
  )
}

export default DisplayG2
