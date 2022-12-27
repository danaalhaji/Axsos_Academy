import React, { useState, useEffect } from 'react'
import axios from 'axios'
import PlayerForm from '../component/PlayerForm'
import { Link, useNavigate } from '@reach/router'
import Header from './Header'
import { navigate } from '@reach/router'

const Create = () => {
    const initialState  ={
        name :"",
        color: "yellow"
    }

    // let navigate=useNavigate();

    const[players, setPlayers] = useState(null)
    const [loaded, setLoaded] = useState(false);
    const [errors, setErrors] = useState([]);
    const [loadedError, setLoadedEr] = useState(false) 

    useEffect(() =>{
        axios.get('http://localhost:8000/api/player')
        .then(res=>{
            setPlayers(res.data);
            setLoaded(true);
        })
        .catch(err => console.error(err.response.data));
    },[]);


    const createAuther = author =>{
        axios.post("http://localhost:8000/api/player", author)
            // .then(res => { setPlayers([...author,res.data], ) })
            .then(()=>navigate('/player/list'))
            .catch(err=>{
                const errorResponse = err.response.data.errors; // Get the errors from err.response.data
                const errorArr = []; // Define a temp error array to push the messages in
                for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                    errorArr.push(errorResponse[key].message)
                }
                // Set Errors
                setErrors(errorArr);
                setLoadedEr(true)
            }) 
        }      
  return (
    <div>
    <Header></Header>
    <Link to="/player/list"> Players List </Link>
    <Link to ="/player/create"> Add Player</Link>
    <PlayerForm onSubmitProps={createAuther} errors={errors} initialState ={initialState}></PlayerForm>
    </div>
  )
}

export default Create
