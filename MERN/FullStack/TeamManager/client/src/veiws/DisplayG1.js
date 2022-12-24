import React, { useEffect, useState } from 'react';
import axios from 'axios';
import GameOne from '../component/GameOne';

const DisplayG1 = () => {
    const [players, setPlayers] = useState(null);
    const [loaded, setLoaded] = useState(false);

    useEffect(() =>{
        axios.get('http://localhost:8000/api/player')
        .then(res=>{
            setPlayers(res.data);
            setLoaded(true);
        })
        .catch(err => console.error(err.response.data));
        console.log("hi")
    },[]);
  return (
    <div>{loaded &&
      <GameOne Players={players}></GameOne>
    }
    </div>
  )
}

export default DisplayG1
