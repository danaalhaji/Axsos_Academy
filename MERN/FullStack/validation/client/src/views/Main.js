import axios from 'axios';
import React, { useEffect, useState } from 'react'
import AutherForm from '../components/AutherForm';
import { navigate } from '@reach/router' 
const Main = (props) => {
    const [author, setAuthor] = useState(null);
    const [loaded, setLoaded] = useState(false);
    const [errors, setErrors] = useState([]);
    const [loadedError, setLoadedEr] = useState(false) 

    useEffect(() =>{
        axios.get('http://localhost:8000/api/auther')
        .then(res=>{
            setAuthor(res.data);
            setLoaded(true);
        })
        .catch(err => console.error(err.response.data));
    },[]);

    const createAuther = author =>{
        axios.post("http://localhost:8000/api/auther", author)
            .then(res => { setAuthor([...author,res.data]);
              navigate("/");})
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
      <AutherForm onSubmitProp={createAuther} errors={errors} lerror={loadedError} initialName =""></AutherForm>
    </div>
  )
}

export default Main
