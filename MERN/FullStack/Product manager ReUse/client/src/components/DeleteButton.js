import React, {useState} from 'react';
import axios from 'axios';

import Button from '@mui/material/Button';

export default props => {
    const { proId, successCallback } = props;

    const deletePoduct = (e) => {
        axios.delete(`http://localhost:8000/api/products/${proId}`)
            .then(res => {
                successCallback();
            })
            .catch(err => console.error(err));
    }


  return (
    <div>
        <Button
        variant="outlined" color="error"
                        onClick={deletePoduct}
                        >Delete Item</Button>
    </div>
  )
}


