import React, { useEffect, useState } from 'react'
import axios from 'axios';
const DisplayResults = (props) => {
  const [results, setResults] = useState({});

  useEffect(()=>{
    console.log("hi");
    axios.get(props.result)
    .then(response => setResults(response.data))
    console.log(results) } ,
    [props.result]);
  return (
    <div>
      <h1>{results.name}</h1>
      {console.log(results)}
      {Object.keys(results).map(key => { return(
  <p>{key} : {results[key]} </p>)})}
    </div>
  )
}

export default DisplayResults
