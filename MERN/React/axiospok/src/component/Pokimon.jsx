import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Pokimon = () => {
    const [responseData, setResponseData] = useState([]);
    useEffect(()=>{
        axios.get('https://pokeapi.co/api/v2/pokemon')
            .then(response=>{setResponseData(response.results); console.log(responseData);})
    }, []);
  return (
    <div>
        {
        responseData.length > 0 && responseData.map((item, index) =>{
            return(<p key={index}>{item.name}</p>)
        })}
    </div>
  )
}

export default Pokimon
