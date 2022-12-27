import React, { useEffect, useState } from 'react';
import axios from 'axios';
import GameOne from '../component/GameOne';
import { Link } from '@reach/router';
import Header from './Header';

const DisplayG1 = () => {
    const [players, setPlayers] = useState([]);
    const [loaded, setLoaded] = useState(false);
    const [player , setPlayer] = useState()
    const [x , setX] = useState(false);

    useEffect(() =>{
        axios.get('http://localhost:8000/api/player')
        .then(res=>{
            setPlayers(res.data);
            setLoaded(true);
        })
        .catch(err => console.error(err.response.data));
        console.log("hi")
    },[]);


    const update =(id, g1Status)=>{

        axios.put('http://localhost:8000/api/player/' + id, {
            g1Status,
        })
        .then(res=>{
        const objIndex = players.findIndex((obj => obj._id == id));
        const player1 = players[objIndex];
        player1.g1Status = g1Status;
        const students1 = [ ...players.slice(0, objIndex),player1,...players.slice(objIndex+1)];
        setPlayers(students1)});
        // setPlayers(players.map((player,i)=>{
        //   if(player._id===id)player.g1Status=g1Status;
        //   return player;
        // }))})

            // .then(  res=>  setX(!x))

        // console.log(students1);
    }
  return (
    <div>
        <Header></Header>
        <Link to="/player/status">Game 1</Link>
        <Link to="/player/game2">Game 2</Link>
        <h1>Game 1 </h1>
        {loaded &&
      <GameOne Players={players} update={update}></GameOne>
    }
    </div>
  )
}

export default DisplayG1
