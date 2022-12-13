import React, { useState } from 'react'

const Pokemon = () => {
    const [names , setNames] = useState("")
    const getAll=()=>{
            fetch('https://pokeapi.co/api/v2/pokemon/')
            .then(response => response.json())
            .then(response => {setNames(response.results);console.log(names);})
    }
  return (
    <div>
      <button onClick={getAll}>Pokemon Names</button>
      {
        names.length > 0 && names.map((item, idx) => {
            return (<p key={idx}>{item.name}</p>)
        })
      }
    </div>
  )
}

export default Pokemon
