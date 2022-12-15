import logo from './logo.svg';
import './App.css';
import SearchForm from './components/SearchForm';
import { useState } from 'react';
import { navigate } from '@reach/router'
import DisplayResults from './components/DisplayResults';

function App() {
    const [type, setType] = useState("");
    const [id, setID] = useState("");
    const [results, setResults] = useState("");
    const recieveData=(type, id)=>{
      setType(type);
      setID(id);
      setResults(`https://swapi.dev/api/${type}/${id}`)
      console.log(results);
    }

  return (
    <div className="App">
      <SearchForm recieveData ={recieveData}></SearchForm>
      <DisplayResults result ={results}> </DisplayResults>
    </div>
  );
}

export default App;
