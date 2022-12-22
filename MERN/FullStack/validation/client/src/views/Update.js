import React, { useEffect, useState } from 'react'
import axios from 'axios';
import AutherForm from '../components/AutherForm';

const Update = (props) => {
    const[author, setAuthor] = useState({})
    const[loaded, setLoaded] = useState(false)
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
            .then(res => console.log(res))
            .catch(err => console.error(err));
    }
  return (
    <div>
      {
        loaded && (<AutherForm onSubmitProp={updateAuthor} initialName={author.name}></AutherForm>)
      }
    </div>
  )
}

export default Update
