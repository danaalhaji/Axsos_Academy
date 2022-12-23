import React, {useState} from 'react';
import axios from 'axios';
import { grey } from '@mui/material/colors';

export default props => {
    const { authId, successCallback } = props;

    const deletePoduct = (e) => {
        axios.delete(`http://localhost:8000/api/auther/${authId}`)
            .then(res => {
                successCallback();
            })
            .catch(err => console.error(err));
    }


  return (
    <div>
        <a href="#"
        variant="outlined"
        style={{color : grey[500]}}
        onClick={deletePoduct}
        >Delete</a>
    </div>
  )
}


