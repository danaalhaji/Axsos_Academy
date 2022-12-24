import axios from 'axios';
import React, { useEffect, useState, useRef } from 'react'

// import { navigate } from '@reach/router' 
import ShowList from '../component/ShowList';



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
      {
        loaded && <ShowList  Players={players}></ShowList>
      }
    </div>
  )
}

export default Main
