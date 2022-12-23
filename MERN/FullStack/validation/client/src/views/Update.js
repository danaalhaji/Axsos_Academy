import React, { useEffect, useState } from 'react'
import axios from 'axios';
import AutherForm from '../components/AutherForm';
import { navigate } from '@reach/router' 

const Update = (props) => {
    const[author, setAuthor] = useState({})
    const[loaded, setLoaded] = useState(false)
    const [errors, setErrors] = useState([]);
    const [loadedError, setLoadedEr] = useState(false) 

    useEffect(() => {
        console.log(props.id)
        axios.get('http://localhost:8000/api/auther/' + props.id)
            .then(res => {
                console.log(res.data)
                setAuthor(res.data.auther);
                setLoaded(true);
            })
    }, []);

    const updateAuthor = author => {
        axios.put('http://localhost:8000/api/auther/' + props.id, author)
        .then(res => {setAuthor([...author,res.data]);
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
      {
        loaded && (<AutherForm onSubmitProp={updateAuthor} errors={errors} lerror={loadedError} initialName={author.name} ></AutherForm>)
      }
    </div>
  )
}

export default Update
