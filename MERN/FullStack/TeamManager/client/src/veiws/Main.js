import { Link } from '@reach/router';
import axios from 'axios';
import React, { useEffect, useState, useRef } from 'react'

// import { navigate } from '@reach/router' 
import ShowList from '../component/ShowList';
import Header from './Header';



const Main = (props) => {
    const [players, setPlayers] = useState(null);
    const [loaded, setLoaded] = useState(false);
    const counter = useRef(0)
    console.log(counter.current++)
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
    <div>
        <Header></Header>
    <Link to="/player/list"> Players List </Link>
    <Link to ="/player/create"> Add Player</Link>
    
      {
        loaded && <ShowList  Players={players}></ShowList>
      }
    </div>
  )
}

export default Main
